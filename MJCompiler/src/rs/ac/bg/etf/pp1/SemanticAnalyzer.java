package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.test.CompilerError;
import rs.ac.bg.etf.pp1.test.CompilerError.CompilerErrorType;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
import sun.security.jca.GetInstance;

import org.apache.log4j.Logger;

public class SemanticAnalyzer extends VisitorAdaptor {
	
	private int printCallCount = 0;
	private int nVars;
	
    private static Struct currentType = NewSymbolTable.noType;
    private static Obj currentMethod = null;
    private static String currentTypeName = "noType";
    
    private static boolean isFormalParam = false;
    private static int argCount;

	private static boolean errorDetection = false;
	private static boolean checkMain = false;
	
	Logger log = Logger.getLogger(getClass());

	
	/* UTIL */
	public int getNumVars() {
		return nVars;
	}
	
	public static boolean isValueableObj(Obj currObj) {
		//Class: currObj.getKind() == Obj.Elem
		if(currObj == null) return false;
		if(currObj.getKind() == Obj.Var || currObj.getKind() == Obj.Fld)
			return true;
		else
			return false;
    }
	public static boolean isIntType(Obj currObj) {
		return currObj.getType().getKind() == Struct.Int;
	}
	public static boolean isIntType(Struct currObj) {
		return currObj.getKind() == Struct.Int;
	}
	
	public static boolean isMethValue(Obj currObj) {
		return currObj.getKind() == Obj.Meth;
	}
	public static String getKindName(int kind) {
		return null;
	}
	//******************************************************************//
	
	public void report_error(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		//log.error(msg.toString());
		MJTestCompile myCompiler = MJTestCompile.getInstance(); 
		myCompiler.addError(new CompilerError(line, msg.toString(), CompilerErrorType.SEMANTIC_ERROR));
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	
	public void visit(VarValue vardecl){
		
		//Multiple declaration check in scope
		Obj temp = NewSymbolTable.find(vardecl.getVarName());
		if(temp != NewSymbolTable.noObj ) {
			if(temp.getLevel()!=0 && currentMethod != null) {
			report_error("Greska! Polje sa zadatim imenom vec postoji! - FUNKCIJA "+ temp.getLevel(), vardecl);
			return;
			}
			if(temp.getKind()==Obj.Var && currentMethod == null) {
				report_error("Greska! Polje sa zadatim imenom vec postoji! - GLOBAL VAR "+ temp.getLevel(), vardecl);
				return;
			}
		}			

		//Proveri da li je promenljiva niz
		Struct varType = currentType;
		
		if(vardecl.getBrackArrayList() instanceof BrackArrayLst) {
			//type is array
			varType = new Struct(Struct.Array, currentType);
		}
		Obj novi;
		//Proveri da li je promenljiva metoda
		if(currentMethod != null) {
			//polje u metodi
			if(isFormalParam) {
				novi = NewSymbolTable.insert(Obj.Fld, vardecl.getVarName(), varType);
			}else {
				novi = NewSymbolTable.insert(Obj.Var, vardecl.getVarName(), varType);
			}
			report_info("Deklarisana promenljiva "+ vardecl.getVarName()+" tip:" + varType.getKind() +" - FUNKCIJA", vardecl);
			novi.setLevel(1);
		}else {
			//globalna promenljiva			
			novi = NewSymbolTable.insert(Obj.Var, vardecl.getVarName(), varType);
			report_info("Deklarisana promenljiva "+ vardecl.getVarName()+" tip:" +  varType.getKind()+" - GLOBAL VAR", vardecl);
			novi.setLevel(0);
		}
		
		if(isFormalParam) argCount++;
		
	}
	
	public void visit(ConstValue constVal) {

		//Check defined type
		if(!(currentType.getKind() == Struct.Bool || currentType.getKind() == Struct.Int || currentType.getKind() == Struct.Char)) {
			report_error("Nevalidan tip: "+currentTypeName, constVal);
			return;
		}
		
		//Check Multi Declaration in same scope
		Obj temp = NewSymbolTable.find(constVal.getConstName());
		if(temp != NewSymbolTable.noObj) {
			report_error("Constanta sa zadatim imenom vec postoji!", constVal);
			return;
		}
		
		//Get constant value type		
		int constType = Struct.None;		
	    if (constVal.getConstOption() instanceof ConstOptionChar) {
	          constType = Struct.Char;
	    } else if (constVal.getConstOption() instanceof ConstOptionBool) {
	          constType = Struct.Bool;
	    }else if(constVal.getConstOption() instanceof ConstOptionNumber) {
	    	constType = Struct.Int;
	    }
	    
	    //Setovana vrednost se ne slaze sa tipom konatante
	    if(constType != currentType.getKind()) {
	    	report_error("Nevalidna vrednost za tip: "+currentTypeName, constVal);
			return;
	    }
	    
		//Ubaci u tabelu simbola
		Obj constNode = NewSymbolTable.insert(Obj.Con, constVal.getConstName(), currentType);
		
		int constValue = 0;
		//Dohvatanje i kastovanje vrednosti konstante
		if (constVal.getConstOption() instanceof ConstOptionChar) {
			constValue = ((CharConstant)((ConstOptionChar)constVal.getConstOption()).getCharConst()).getC1();
	    } else if (constVal.getConstOption() instanceof ConstOptionBool) {
	    	constValue = ((BoolConstant)((ConstOptionBool)constVal.getConstOption()).getBoolConst()).getB1();
	    }else if(constVal.getConstOption() instanceof ConstOptionNumber) {
	    	constValue =((NumberConstant)((ConstOptionNumber)constVal.getConstOption()).getNumConst()).getN1();
	    }
		//setovanje vrednosti datog covra
		constNode.setAdr(constValue);
		
		report_info("Deklarisana CONST promenljiva "+ constVal.getConstName()+" tip:" + currentTypeName+" Vredosti: "+constValue, constVal);
	}
	
	
    public void visit(PrintStatemtDetail print) {
		//print.obj = print.getExpr().obj;
		Struct exprStruct = print.getExpr().struct;
		
		int currtype = Struct.None;
    	
		if(exprStruct.getElemType() == null) {
    		currtype = exprStruct.getKind();
    	}else{
    		currtype = exprStruct.getElemType().getKind();
    	}
	
    	
    	if(!(currtype == Struct.Int
    			|| currtype == Struct.Char
    			|| currtype == Struct.Bool)) {
    		
    		report_error("Greska! Print operand mora biti int, char ili boolean tipa!", print);
    		return;
    	}
    	report_info("Pronadjen Print Statement ", print);
	}
    
    public void visit(ReadStatementDetail read) {
    	//read.obj = read.getDesignator().obj;
    	Struct desStrcut =  read.getDesignator().obj.getType();
    	
    	if(!isValueableObj(read.getDesignator().obj)){
  		   report_error("Greska! Desigantor za Read mora biti vrednostan!", read);
  		   return;
  	  	}
    	
    	int currtype = Struct.None;
    	if(desStrcut.getElemType() == null) {
    		currtype = desStrcut.getKind();
    	}else{
    		currtype = desStrcut.getElemType().getKind();
    	}
    	
    	if(!(currtype == Struct.Int
    			|| currtype == Struct.Char
    			|| currtype == Struct.Bool)) {
    		
    		report_error("Greska! Read operand mora biti int, char ili boolean tipa!", read);
    		return;
    	}
    	report_info("Pronadjen Read Statement ", read);
    }
    
    public void visit(CondFactorSingle cond) {
    	cond.struct = cond.getExpr().struct;
    	if(cond.struct.getKind() != Struct.Bool) {
    		report_error("Greska! Tip uslovne promenljive mora biti Boolean", cond);
    		return;
    	}
    }
    public void visit(CondFactorMulti cond) {
    	Struct op1 = cond.getExpr().struct;
    	Struct op2 = cond.getExpr1().struct;
    	
    	//provera kompatabilnosti tipova
    	if(!op1.compatibleWith(op2)) {
    		report_error("Greska! Tipovi uslovnih promenljivih moraju biti kompatabilni!", cond);
    		return;
    	}
    	//provera operatora za nizove
    	if(op1.isRefType() || op2.isRefType()) {
    		if(!(cond.getRelop() instanceof IsEqualRelOp || cond.getRelop() instanceof NotEqualRelOp)) {
    			report_error("Greska! Relacioni operatori nizovskih tipova mogu biti samo == i !=!", cond);
        		return;
    		}
    	}
    	cond.struct = NewSymbolTable.booleanType;
    }
    public void visit(SingleCondTerm cond) {
    	cond.struct = cond.getCondFact().struct;
    }
    public void visit(MultiCondTerm cond) {
    	cond.struct = cond.getCondFact().struct;
    }
    public void visit(SingleCondition cond) {
    	cond.struct = cond.getCondTerm().struct;
    }
    public void visit(MultiCondition cond) {
    	cond.struct = cond.getCondTerm().struct;
    }
        
    //****************************************** PROG ************************************
    public void visit(ProgName progName) {
    	progName.obj = NewSymbolTable.insert(Obj.Prog, progName.getProgName(), NewSymbolTable.noType);
    	NewSymbolTable.openScope();
    }
    public void visit(Program program) {
    	if(!checkMain) {
    		report_error("Greska! Nije pronadjena main metoda! ", null);
    	}
    	nVars = NewSymbolTable.currentScope.getnVars();
    	NewSymbolTable.chainLocalSymbols(program.getProgName().obj);
    	NewSymbolTable.closeScope();
    }
    
    public void visit(Type type) {
    	Obj typeNode = NewSymbolTable.find(type.getTypeName());
    	if(typeNode == NewSymbolTable.noObj) {
    		report_error("Nije pronadjen tip "+ type.getTypeName()+" u tabeli simbola! ", null);
    		type.struct = NewSymbolTable.noType;
    	}else {
    		if(Obj.Type == typeNode.getKind()) {
    			type.struct = typeNode.getType();
    			currentType =  typeNode.getType();
    			currentTypeName = type.getTypeName();
    		}else {
    			report_error("Greska: Ime "+ type.getTypeName()+" ne predstavlja Tip! ", type);
    			type.struct = NewSymbolTable.noType;
    		}
    	}
    }
    
    public void visit(MethodHeader methHeader) {
    	
    	//Multiple declaration check
    	Obj temp = NewSymbolTable.find(methHeader.getMethName());
		if(temp != NewSymbolTable.noObj) {
			report_error("Greska! Postoji funckija sa unetim imenom! ", null);
			methHeader.obj = NewSymbolTable.lenObj;
			return;
		}
		
    	Struct retType = NewSymbolTable.noType;
    	
    	if(methHeader.getMethodDeclType() instanceof CustomMethodDeclType) {
    		retType = currentType;				//type
    	}else {
    		retType = NewSymbolTable.noType;	//void    		
    	}
    	
    	//Check main method
    	if(methHeader.getMethName().equals("main") ) {
    		checkMain = true;
    	}    	
    	
    	//Check main method
    	if(methHeader.getMethName().equals("main") && retType!= NewSymbolTable.noType) {
    		report_error("Greska! Metoda main mora biti tipa void! ", methHeader);
//    		methHeader.obj = NewSymbolTable.lenObj;
//    		return;
    	}
    		
    	currentMethod = NewSymbolTable.insert(Obj.Meth,methHeader.getMethName(), currentType);
    	methHeader.obj = currentMethod;
    	NewSymbolTable.openScope();
    	report_info("Obradjuje se metoda: "+ methHeader.getMethName(), methHeader);
    }
    
    public void visit(MethodDecl methDecl) {
    	NewSymbolTable.chainLocalSymbols(currentMethod);
    	NewSymbolTable.closeScope();
    	currentMethod = null;
    }
    
    public void visit(FormParamsBegin formalBeg) {
    	isFormalParam = true;
    	argCount = 0;
    }
    
    public void visit(FormParamsEnd formalEnd) {
    	isFormalParam = false;
    	//Da li main ima parameter
    	if(currentMethod.getName().equals("main") && argCount != 0) {
    		report_error("Greska! Metoda main ne sme imati argumente! ", formalEnd);
    		return;
    	}
    }
    
   public void visit(Designator designator) {
	   Obj des = NewSymbolTable.find(designator.getDesigantorName());
	   designator.obj = des;
	   
	   if(des == NewSymbolTable.noObj) {
		   report_error("Greska! Designator "+ designator.getDesigantorName()+" nije deklarisan!", designator);
		   return;
	   }
	   
	   if(designator.getDesigantorList() instanceof DsgnList) {
		   if(designator.obj.getType().getKind() != Struct.Array){
			   report_error("Greska! Indeksiranje moguce samo nad nizovnim promenljivama!", designator);
			   return;
		   }
		   
		   DsgnList dsnList = (DsgnList)designator.getDesigantorList();
		   
		   if(!isIntType(dsnList.getExpr().struct)) {
			   report_error("Greska!Expression mora biti tipa INT!00000", designator);
			   
		   }
	   }	   
	  
	   report_info("Designator "+ designator.getDesigantorName()+" pronadjen!", designator);

   }
    
   public void visit(FunctionCall funcCall) {
	   Obj currFuncCall = funcCall.getDesignator().obj;
	   if(isMethValue(currFuncCall)) {
		   report_error("Greska! "+ funcCall.getDesignator()+" nije m!", funcCall);
		   return;
	   }
	   report_info("FUNC: "+currFuncCall.getName(), null);
   }
   public void visit(DesignatorStatementInc desInc) {
	   Designator desigantor = desInc.getDesignator();
	   Struct desStruct = desigantor.obj.getType();
	   
	   if(desigantor.getDesigantorList() instanceof DsgnList) {
		   desStruct = desigantor.obj.getType().getElemType();   
	   }
	   if(!isIntType(desStruct)) {
		   report_error("Greska! Desigantor za Inkrement mora biti vrtipa INT!", desInc);
		   return;
	   }   
	   
	   if(!isValueableObj(desInc.getDesignator().obj)){
		   report_error("Greska! Desigantor za Inkrement mora biti vrednostan!", desInc);
		   return;
	   }

   }
   public void visit(DesignatorStatementDec desDec) {
	   Designator desigantor = desDec.getDesignator();
	   Struct desStruct = desigantor.obj.getType();
	   
	   if(desigantor.getDesigantorList() instanceof DsgnList) {
		   desStruct = desigantor.obj.getType().getElemType();   
	   }
	   if(!isIntType(desStruct)) {
		   report_error("Greska! Desigantor za Dekrement mora biti vrtipa INT!", desDec);
		   return;
	   }   
	   
	   if(!isValueableObj(desigantor.obj)){
		   report_error("Greska! Desigantor za Dekrement mora biti vrednostan!", desDec);
		   return;
	   }	   
	   
   }
   public void visit(AssignOpeeratorExpresion assignOp) {
	   
	   if(!isValueableObj(assignOp.getDesignator().obj)){
		   report_error("Greska! Desigantor za Dodelu vrednosti mora biti vrednostan!", assignOp);
		   return;
	   }
	   Designator desigantor = assignOp.getDesignator();
	   Struct desStruct = desigantor.obj.getType();
	   
	   if(desigantor.getDesigantorList() instanceof DsgnList) {
		   desStruct = desigantor.obj.getType().getElemType();   
	   }
	   
	   Struct op1 = desStruct;
	   Struct op2 = assignOp.getExpr().struct;
	   
	   if(op1 == NewSymbolTable.noType) {
		   report_error("Greska! Nepostojeci operand!", assignOp);
		   return;
	   }
	   
	   if(NewSymbolTable.noType.equals(op2) ) {
		   report_error("Greska! Nepostojeci operand!", assignOp);
		   return;
	   }
	   
	   //Check type compatibility
	   
	   //case 1
	   if(op1.getElemType() != null && op2.getElemType() == null) {
		   if(!op1.getElemType().equals(op2)) {
			   report_error("Greska! Nekompatabilni tipovi! ---:"+ op1.getKind(), assignOp);
			   return;
		   }
	   }
	   
	   //case2
	   if(op2.getElemType() != null && op1.getElemType() == null) {
		   if(!op2.getElemType().equals(op1)) {
			   report_error("Greska! Nekompatabilni tipovi! ---:"+ op1.getKind(), assignOp);
			   return;
		   }
	   }
	   //case 3
	   if(op2.getElemType() != null && op1.getElemType() != null) {
		   if(!op2.getElemType().equals(op1.getElemType())) {
			   report_error("Greska! Nekompatabilni tipovi! ---:"+ op1.getKind(), assignOp);
			   return;
		   }
	   }
	   	   
	   //case 4
	   if(op2.getElemType() == null && op1.getElemType() == null) {
		   if(!op2.equals(op1)) {
			   report_error("Greska! Nekompatabilni tipovi! ---:"+ op1.getKind(), assignOp);
			   return;
		   }
	   }
	   
   }
   //********************************** Expr AddOp***********************************************
   public void visit(Expression expr) {
	   expr.struct = expr.getTerm().struct;
	   
	   if(expr.struct == NewSymbolTable.noType) {
		   report_error("Greska! Nepostojeci operand!", expr);
		   return;
	   }

	   //provera negativne vrednosti
	   if(expr.getNegPrefix() instanceof NegativePrefix) {
		   if(!isIntType(expr.getTerm().struct)) {
			   report_error("Greska! Expr: Negativna Vrednost mora biti tipa INT!", expr);
			   return;
		   }
	   }
	   
	   //Provera operanada
	   if(expr.getExprList() instanceof ExpressionList) {
		   Struct op1 = expr.getTerm().struct;
		   Struct op2 = ((ExpressionListValue)((ExpressionList)expr.getExprList()).getExprListVal()).getTerm().struct;
		   
		   //operand 1
		   
		   if(op1.getElemType() == null) {
			   if(!isIntType(op1)) {
				   report_error("Greska! Expr: Operand1 mora biti tipa INT!", expr);
				   return;
			   }
		   }else {
			   if(op1.getElemType().getKind() != Struct.Int) {
				   report_error("Greska! Expr: Operand1 mora biti tipa INT!", expr);
				   return;
			   }
		   }
		 
		   
		   //operand 2
		   if(op2.getElemType() == null) {
			   if(!isIntType(op2)) {
				   report_error("Greska! Expr: Operand2 mora biti tipa INT!", expr);
				   return;
			   }
		   }else {
			   if(op2.getElemType().getKind() != Struct.Int) {
				   report_error("Greska! Expr: Operand2 mora biti tipa INT!", expr);
				   return;
			   }
		   }
	   }
   }
  

   
   //********************************** TERM MulOp***********************************************
   
   public void visit(BasicTerm term) {
	   term.struct = term.getFactor().struct;
	   
	   if(term.struct == NewSymbolTable.noType) {
		   report_error("Greska! Nepostojeci operand!", term);
		   return;
	   }
	   
	   // Mul : /, *, %
	   if(term.getTermRepeat() instanceof MulOptTerm) {
		   //Treba proveriti da li su oba operanda tipa INT
		   
		   
		   Struct op1 = term.struct;
		   Struct op2 = ((MulOptTerm)term.getTermRepeat()).getFactor().struct;
		   
		   //operand 1
		   
		   if(op1.getElemType() == null) {	//isArray
			   if(!isIntType(op1)) {
				   report_error("Greska! Expr: Operand1 mora biti tipa INT!", term);
				   return;
			   }
		   }else {
			   if(op1.getElemType().getKind() != Struct.Int) {
				   report_error("Greska! Expr: Operand1 mora biti tipa INT!" , term);
				   return;
			   }
		   }
		 
		   
		   //operand 2
		   if(op2.getElemType() == null) {	//isArray
			   if(!isIntType(op2)) {
				   report_error("Greska! Expr: Operand2 mora biti tipa INT!", term);
				   return;
			   }
		   }else {
			   if(op2.getElemType().getKind() != Struct.Int) {
				   report_error("Greska! Expr: Operand2 mora biti tipa INT!", term);
				   return;
			   }
		   }
	   }	   
   }
   
   //*********************************** FACTOR **************************************************
   public void visit(FactorNumConst factor) {
	   if(factor.struct == NewSymbolTable.noType) {
		   report_error("Greska! Konstanta nepostojeca!", factor);
		   return;
	   }
	   factor.struct = factor.getNumConst().struct;
	   
   }
   
   public void visit(FactorCharConst factor) {
	   if(factor.struct == NewSymbolTable.noType) {
		   report_error("Greska! Konstanta nepostojeca!", factor);
		   return;
	   }
	   factor.struct = factor.getCharConst().struct;
   }
   public void visit(FactorBoolConst factor) {
	   if(factor.struct == NewSymbolTable.noType) {
		   report_error("Greska! Konstanta nepostojeca!", factor);
		   return;
	   }
	   factor.struct = factor.getBoolConst().struct;
   }
   public void visit(FacorExpression factor) {
	   if(factor.struct == NewSymbolTable.noType) {
		   report_error("Greska! Izraz nepostojeci!", factor);
		   return;
	   }
	   factor.struct = factor.getExpr().struct;
   }
   public void visit(FactorNewType factor) {
	   
	   if(factor.getExprFactorOpt() instanceof ExpressionFactorOption) {
		   if(!isIntType(((ExpressionFactorOption)factor.getExprFactorOpt()).getExpr().struct)) {
			   report_error("Greska!Expression mora biti tipa INT!", factor);
			   return;
		   }
		   factor.struct = new Struct(Struct.Array, currentType);
	   }
//	   else {
//	   }
	   
   }
   public void visit(FactorDesignator factor) {
	   factor.struct = factor.getDesignator().obj.getType(); 
	   
	   if(factor.struct == NewSymbolTable.noType) {
		   report_error("Greska! Designator nepostojeci!", factor);
	   } 
	   
	   Designator desigantor = factor.getDesignator();
	   Struct desStruct = desigantor.obj.getType();
	   
	   if(desigantor.getDesigantorList() instanceof DsgnList) {
		   desStruct = desigantor.obj.getType().getElemType(); 
		   factor.struct = desStruct;
	   }
//	   if(!isIntType(desStruct)) {
//		   report_error("Greska! Factor designator mora biti vrtipa INT!", factor);
//		   return;
//	   }   
	   
   }
  
   public void visit(NumberConstant numConst) {
	   int constValue = numConst.getN1();
	   numConst.struct = NewSymbolTable.intType;
	   numConst.setN1(constValue);   
   }
   public void visit(CharConstant charConst) {
	   char constValue = charConst.getC1();
	   charConst.struct = NewSymbolTable.charType;
	   charConst.setC1(constValue);
   }
   public void visit(BoolConstant boolConst) {
	   int constValue = boolConst.getB1();
	   boolConst.struct = NewSymbolTable.booleanType;
	   boolConst.setB1(constValue);
   }
   
   //********************************* ERRORS *****************************
   public void visit(ErrorConstGlobalDeclarationSemi error) {
	   errorDetection = true;
   }
   public void visit(ErrorConstGlobalDeclarationComma error) {
	   errorDetection = true;
   }
   public void visit(ErrorVarGlobalDeclarationSemi error) {
	   errorDetection = true;
   }
   
   public void visit(ErrorVarGlobalDeclarationComma error) {
	   errorDetection = true;
   }
   public void visit(ErrorFormalParamesComma error) {
	   errorDetection = true;
   }
   public void visit(ErrorAssignExpression error) {
	   errorDetection = true;
   }
   public void visit(ErrorCondition error) {
	   errorDetection = true;
   }
   public boolean passed() {
	   return errorDetection;
   }
}

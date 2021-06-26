package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;

import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

import org.apache.log4j.Logger;

public class SemanticPass extends VisitorAdaptor {
	
	int printCallCount = 0;
	int nVars;
	
    private static Struct currentType = NewSymbolTable.noType;
    private static Obj currentMethod = null;
    private static String currentTypeName = "noType";
    
    private static boolean isFormalParam = false;
    private static int argCount;

	
	Logger log = Logger.getLogger(getClass());

	
	/* UTIL */
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
	
	public static boolean isMethValue(Obj currObj) {
		return currObj.getKind() == Obj.Meth;
	}
	//******************************************************************//
	
	public void report_error(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
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
			if(temp.getKind()==Obj.Fld && currentMethod != null) {
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
		
		//Proveri da li je promenljiva metoda
		if(currentMethod != null) {
			//polje u metodi
			NewSymbolTable.insert(Obj.Fld, vardecl.getVarName(), varType);
			report_info("Deklarisana promenljiva "+ vardecl.getVarName()+" tip:" + currentTypeName +" - FUNKCIJA", vardecl);
		}else {
			//globalna promenljiva			
			NewSymbolTable.insert(Obj.Var, vardecl.getVarName(), varType);
			report_info("Deklarisana promenljiva "+ vardecl.getVarName()+" tip:" + currentTypeName+" - GLOBAL VAR", vardecl);
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
	
	
    public void visit(PrintStmt print) {
		printCallCount++;
	}
    
    public void visit(ProgName progName) {
    	progName.obj = NewSymbolTable.insert(Obj.Prog, progName.getProgName(), NewSymbolTable.noType);
    	NewSymbolTable.openScope();
    }
    public void visit(Program program) {
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
			return;
		}
		
    	Struct retType = NewSymbolTable.noType;
    	
    	if(methHeader.getMethodDeclType() instanceof CustomMethodDeclType) {
    		retType = currentType;				//type
    	}else {
    		retType = NewSymbolTable.noType;	//void    		
    	}
    	
    	//Check main method
    	if(methHeader.getMethName().equals("main") && retType!= NewSymbolTable.noType) {
    		report_error("Greska! Metoda main mora biti tipa void! ", methHeader);
    		return;
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
	   if(!isValueableObj(desInc.getDesignator().obj)){
		   report_error("Greska! Desigantor za Inkrement mora biti vrednostan!", desInc);
		   return;
	   }
	   if(!isIntType(desInc.getDesignator().obj)) {
		   report_error("Greska! Desigantor za Inkrement mora biti vrtipa INT!", desInc);
		   return;
	   }
   }
   public void visit(DesignatorStatementDec desDec) {
	   if(!isValueableObj(desDec.getDesignator().obj)){
		   report_error("Greska! Desigantor za Dekrement mora biti vrednostan!", desDec);
		   return;
	   }
	   if(!isIntType(desDec.getDesignator().obj)) {
		   report_error("Greska! Desigantor za Dekrement mora biti vrtipa INT!", desDec);
		   return;
	   }
   }
   public void visit(AssignOpeeratorExpresion assignOp) {
	   
	   
	   if(!isValueableObj(assignOp.getDesignator().obj)){
		   report_error("Greska! Desigantor za Dodelu vrednosti mora biti vrednostan!", assignOp);
		   return;
	   }
	   
	   Obj op1 = assignOp.getDesignator().obj;
	   Obj op2 = assignOp.getExpr().obj;
	   
	   if(op1 == NewSymbolTable.noObj) {
		   report_error("Greska! Nepostojeci operand!", assignOp);
		   return;
	   }
	   
	   if(NewSymbolTable.noObj.equals(op2) ) {
		   report_error("Greska! Nepostojeci operand!", assignOp);
		   return;
	   }
	   
	   //Check type compatibility
	   
	   //case 1
	   if(op1.getType().getElemType() != null && op2.getType().getElemType() == null) {
		   if(!op1.getType().getElemType().equals(op2.getType())) {
			   report_error("Greska! Nekompatabilni tipovi! ---:"+ op1.getType().getKind(), assignOp);
			   return;
		   }
	   }
	   
	   //case2
	   if(op2.getType().getElemType() != null && op1.getType().getElemType() == null) {
		   if(!op2.getType().getElemType().equals(op1.getType())) {
			   report_error("Greska! Nekompatabilni tipovi! ---:"+ op1.getType().getKind(), assignOp);
			   return;
		   }
	   }
	   //case 3
	   if(op2.getType().getElemType() != null && op1.getType().getElemType() != null) {
		   if(!op2.getType().getElemType().equals(op1.getType().getElemType())) {
			   report_error("Greska! Nekompatabilni tipovi! ---:"+ op1.getType().getKind(), assignOp);
			   return;
		   }
	   }
	   	   
	   //case 4
	   if(op2.getType().getElemType() == null && op1.getType().getElemType() == null) {
		   if(!op2.getType().equals(op1.getType())) {
			   report_error("Greska! Nekompatabilni tipovi! ---:"+ op1.getType().getKind(), assignOp);
			   return;
		   }
	   }
	   
   }
   //********************************** Expr AddOp***********************************************
   public void visit(Expression expr) {
	   expr.obj = expr.getTerm().obj;
	   
	   if(expr.obj == NewSymbolTable.noObj) {
		   report_error("Greska! Nepostojeci operand!", expr);
		   expr.obj = NewSymbolTable.noObj;
		   return;
	   }

	   //provera negativne vrednosti
	   if(expr.getNegPrefix() instanceof NegativePrefix) {
		   if(!isIntType(expr.getTerm().obj)) {
			   report_error("Greska! Expr: Negativna Vrednost mora biti tipa INT!", expr);
			   return;
		   }
	   }
	   
	   //Provera operanada
	   if(expr.getExprList() instanceof ExpressionList) {
		   Obj op1 = expr.getTerm().obj;
		   Obj op2 = ((ExpressionListValue)((ExpressionList)expr.getExprList()).getExprListVal()).getTerm().obj;
		   
		   //operand 1
		   
		   if(op1.getType().getElemType() == null) {
			   if(!isIntType(op1)) {
				   report_error("Greska! Expr: Operand1 mora biti tipa INT!", expr);
				   return;
			   }
		   }else {
			   if(op1.getType().getElemType().getKind() != Struct.Int) {
				   report_error("Greska! Expr: Operand1 mora biti tipa INT!" + op1.getType().getElemType().getKind(), expr);
				   return;
			   }
		   }
		 
		   
		   //operand 2
		   if(op2.getType().getElemType() == null) {
			   if(!isIntType(op2)) {
				   report_error("Greska! Expr: Operand2 mora biti tipa INT!", expr);
				   return;
			   }
		   }else {
			   if(op2.getType().getElemType().getKind() != Struct.Int) {
				   report_error("Greska! Expr: Operand2 mora biti tipa INT!", expr);
				   return;
			   }
		   }
	   }
   }
  
   
   //********************************** TERM MulOp***********************************************
   
   public void visit(BasicTerm term) {
	   term.obj = term.getFactor().obj;
	   
	   if(term.obj == NewSymbolTable.noObj) {
		   report_error("Greska! Nepostojeci operand!", term);
		   return;
	   }
	   
	   // Mul : /, *, %
	   if(term.getTermRepeat() instanceof MulOptTerm) {
		   //Treba proveriti da li su oba operanda tipa INT
		   
		   //operand 1
		   if(!isIntType(term.obj)) {
			   report_error("Greska! Term: Operand1 mora biti tipa INT!", term);
			   return;
		   }
		   
		   //operand 2
		   if(!isIntType(((MulOptTerm)term.getTermRepeat()).getFactor().obj)) {
			   report_error("Greska! Term: Operand2 mora biti tipa INT!", term);
			   return;
		   }
	   }	   
   }
   
   //*********************************** FACTOR **************************************************
   public void visit(FactorNumConst factor) {
	   if(factor.obj == NewSymbolTable.noObj) {
		   report_error("Greska! Konstanta nepostojeca!", factor);
		   return;
	   }
	   factor.obj = factor.getNumConst().obj;
   }
   
   public void visit(FactorCharConst factor) {
	   if(factor.obj == NewSymbolTable.noObj) {
		   report_error("Greska! Konstanta nepostojeca!", factor);
		   return;
	   }
	   factor.obj = factor.getCharConst().obj;
   }
   public void visit(FactorBoolConst factor) {
	   if(factor.obj == NewSymbolTable.noObj) {
		   report_error("Greska! Konstanta nepostojeca!", factor);
		   return;
	   }
	   factor.obj = factor.getBoolConst().obj;
   }
   public void visit(FacorExpression factor) {
	   if(factor.obj == NewSymbolTable.noObj) {
		   report_error("Greska! Izraz nepostojeci!", factor);
		   return;
	   }
	   factor.obj = factor.getExpr().obj;
   }
   public void visit(FactorNewType factor) {
	   
	   if(factor.getExprFactorOpt() instanceof ExpressionFactorOption) {
		   if(!isIntType(((ExpressionFactorOption)factor.getExprFactorOpt()).getExpr().obj)) {
			   report_error("Greska!Expression mora biti tipa INT!", factor);
			   return;
		   }
		   factor.obj = new Obj(Obj.Var,"newVarArray", currentType);
	   }else {
		   factor.obj = new Obj(Obj.Var,"newVar", currentType);
	   }
   }
   public void visit(FactorDesignator factor) {
	   if(factor.obj == NewSymbolTable.noObj) {
		   report_error("Greska! Designator nepostojeci!", factor);
		  
	   }
	   if(((Designator)factor.getDesignator()).getDesigantorList() instanceof DsgnList) {
		   if(!isIntType(((DsgnList)((Designator)factor.getDesignator()).getDesigantorList()).getExpr().obj)) {
			   report_error("Greska!Expression mora biti tipa INT!", factor);
			   
		   }
	   }	   
	  
	   factor.obj = factor.getDesignator().obj; 
   }
  
   public void visit(NumberConstant numConst) {
	   
	   int constValue = numConst.getN1();
	   numConst.obj = new Obj(Obj.Con,"NumConst", NewSymbolTable.intType);
	   numConst.setN1(constValue);   

   }
   public void visit(CharConstant charConst) {
	   char constValue = charConst.getC1();
	   charConst.obj = new Obj(Obj.Con,"CharConst", NewSymbolTable.charType);
	   charConst.setC1(constValue);
   }
   public void visit(BoolConstant boolConst) {
	   int constValue = boolConst.getB1();
	   boolConst.obj = new Obj(Obj.Con,"BoolConst", NewSymbolTable.booleanType);
	   boolConst.setB1(constValue);
   }
}

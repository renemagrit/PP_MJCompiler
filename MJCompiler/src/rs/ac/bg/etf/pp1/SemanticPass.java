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
	
	Logger log = Logger.getLogger(getClass());

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
		
		//Check Multi Declaration in same scope
		Obj temp = NewSymbolTable.find(vardecl.getVarName());
		if(temp != NewSymbolTable.noObj) {
			if(temp.getKind() == Obj.Fld && currentMethod != null) {
				report_error("Polje sa zadatim imenom vec postoji! - FUNKCIJA "+ temp.getLevel(), vardecl);
				return;
			}
			if(temp.getKind() == Obj.Var && currentMethod == null) {
				report_error("Polje sa zadatim imenom vec postoji! - GLOBAL VAR "+ temp.getLevel(), vardecl);
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
			report_info("Deklarisana VAR promenljiva "+ vardecl.getVarName()+" tip:" + currentTypeName +" - FUNKCIJA", vardecl);
		}else {
			//globalna promenljiva
			NewSymbolTable.insert(Obj.Var, vardecl.getVarName(), varType);
			report_info("Deklarisana VAR promenljiva "+ vardecl.getVarName()+" tip:" + currentTypeName+" - GLOBAL VAR", vardecl);
		}	
		
		
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
    	//TO DO: provera broja arguemanata za main
    	
    	currentMethod = NewSymbolTable.insert(Obj.Meth,methHeader.getMethName(), currentType);
    	methHeader.obj = currentMethod;
    	NewSymbolTable.currentScope();
    	report_info("Obradjuje se metoda: "+ methHeader.getMethName(), methHeader);
    }
    
    public void visit(MethodDecl methDecl) {
    	NewSymbolTable.chainLocalSymbols(currentMethod);
    	NewSymbolTable.closeScope();
    	report_info("PKRAJ PARAM", null);
    	currentMethod = null;
    }
    
    public void visit(FormParamsBegin formalBeg) {
    	report_info("POCETAK PARAM", null);
    }
}

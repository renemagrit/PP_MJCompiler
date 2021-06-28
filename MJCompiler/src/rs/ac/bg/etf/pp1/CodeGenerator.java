package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Stack;

import com.sun.istack.internal.logging.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.test.CompilerError;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.*;

public class CodeGenerator extends VisitorAdaptor {
	private int mainPc;

	private ArrayList<Integer> listOfFalseJumps = new ArrayList<Integer>();
	private ArrayList<Integer> listOfOrJumps = new ArrayList<Integer>();
	private Stack<ArrayList<Integer>> stackOfFalseJumps = new Stack<ArrayList<Integer>>();
	private Stack<ArrayList<Integer>> stackOforJums = new Stack<ArrayList<Integer>>();
	private Stack<Integer> stackOfAfterElseAddrs = new Stack<Integer>();
	
	private int afterElseAddr;
	
	public int getMainPc() {
		return mainPc;
	}
	private static Logger log = Logger.getLogger(CodeGenerator.class);

	public void report_info(String message, SyntaxNode info) {
        StringBuilder msg = new StringBuilder(message);
        int line = (info == null) ? 0 : info.getLine();
        if (line != 0)
            msg.append(", line ").append(line);
        log.info(msg.toString());
    }

	public void visit(FactorNumConst numConst) {
		int constValue = ((NumberConstant) numConst.getNumConst()).getN1();
		Code.loadConst(constValue);
	}

	public void visit(FactorCharConst charConst) {
		int constValue = ((CharConstant) charConst.getCharConst()).getC1();
		Code.loadConst(constValue);
	}

	public void visit(FactorBoolConst boolConst) {
		int constValue = ((BoolConstant) boolConst.getBoolConst()).getB1();
		Code.loadConst(constValue);
	}

	public void visit(FactorDesignator desFactor) {
		Code.load(desFactor.getDesignator().obj);
	}

	public void visit(FactorNewType newfactor) {
		Code.put(Code.newarray);

		// znam da mi je ovo nepotrbno jer ne radim klase
		if (newfactor.getExprFactorOpt() instanceof ExpressionFactorOption) {

			if (((ExpressionFactorOption) newfactor.getExprFactorOpt()).getExpr().struct.getKind() == Struct.Int) {
				Code.put(1); // niz reci
			} else {
				Code.put(0); // niz bajtova
			}

		}
	}

	public void visit(AssignOpeeratorExpresion assop) {
		Code.store(assop.getDesignator().obj);
	}
	
	//********************************** NEG *************************************
	public void visit(NegativePrefix neg) {
		Code.put(Code.neg);
	}
	
	//********************************** ADD/SUB***********************************
	public void visit(ExpressionListValue exp) {
		if(exp.getAddop() instanceof PlusOp) {
			Code.put(Code.add);
		}else if(exp.getAddop() instanceof MinusOp){
			Code.put(Code.sub);
		}
	}
	
	//************************************* MUL/DIV/MOD ****************************
	public void visit(MulOptTerm expr) {
		if(expr.getMulop() instanceof DivOption) {
			Code.put(Code.div);
		}else if(expr.getMulop() instanceof ModOption) {
			Code.put(Code.rem);
		}else if(expr.getMulop() instanceof MulOption){
			Code.put(Code.mul);
		}
	}
	// *********************************** INC and DEC ******************************
	public void visit(DesignatorStatementInc desInc) {
		Designator desigantor = desInc.getDesignator();
		
		if (desigantor.getDesigantorList() instanceof DsgnList) {
			// TODO: array
		}else {
			Code.load(desInc.getDesignator().obj);
			Code.loadConst(1);
			Code.put(Code.add);
			Code.store(desInc.getDesignator().obj);
		}
		

	}

	public void visit(DesignatorStatementDec desDec) {
		Designator desigantor = desDec.getDesignator();
		
		if (desigantor.getDesigantorList() instanceof DsgnList) {
			// TODO: array
		} else {
			Code.load(desDec.getDesignator().obj);
			Code.loadConst(1);
			Code.put(Code.sub);
			Code.store(desDec.getDesignator().obj);
		}
	}
	//******************************** PROG **************************************
//	public void visit(ProgName progName) {
//		 Obj chrMethObj = NewSymbolTable.find("chr");
//	        // report_info("[CHR]" + stringifyObjNode(chrMethObj), null);
//	        chrMethObj.setAdr(Code.pc);
//	        Code.put(Code.enter);
//	        Code.put(1);
//	        Code.put(1);
//
//	        Code.put(Code.load_n);
//
//	        Code.put(Code.exit);
//	        Code.put(Code.return_);
//
//
//	        Obj ordMethObj = NewSymbolTable.find("ord");
//	        // report_info("[ORD]" + stringifyObjNode(ordMethObj), null);
//	        ordMethObj.setAdr(Code.pc);
//	        Code.put(Code.enter);
//	        Code.put(1);
//	        Code.put(1);
//
//	        Code.put(Code.load_n);
//
//	        Code.put(Code.exit);
//	        Code.put(Code.return_);
//
//
//	        Obj lenMethObj = NewSymbolTable.find("len");
//	        // report_info("[LEN]" + stringifyObjNode(lenMethObj), null);
//	        lenMethObj.setAdr(Code.pc);
//	        Code.put(Code.enter);
//	        Code.put(1);
//	        Code.put(1);
//
//	        Code.put(Code.load_n);
//	        Code.put(Code.arraylength);
//
//	        Code.put(Code.exit);
//	        Code.put(Code.return_);
//    }
	
	//********************************** IF STMT ************************************
	public void visit(IfStatementFull stmt) {
		//pop
		afterElseAddr = stackOfAfterElseAddrs.pop();
		listOfFalseJumps = stackOfFalseJumps.pop();
		listOfOrJumps = stackOforJums.pop();
	}
	public void visit(IfStatementDetection cond) {
		//push
		stackOfAfterElseAddrs.push(afterElseAddr);
		stackOfFalseJumps.push(listOfFalseJumps);
		stackOforJums.push(listOfOrJumps);
		
		listOfFalseJumps = new ArrayList<Integer>();
		listOfOrJumps = new ArrayList<Integer>();
	}
	
	public void visit(ConditionStatemnt stmt) {
		
		//if then grana
		listOfOrJumps.forEach((elem)->{
			Code.fixup(elem);
		});
		listOfOrJumps.clear();
	}
	public void visit(NoElseStatement stmt) {
		listOfFalseJumps.forEach(elem->{
			Code.fixup(elem);
		});
		listOfFalseJumps.clear();
	}
	public void visit(ElseStatements stmt) {
		Code.fixup(afterElseAddr);
	}
	public void visit(EleseDetection stmt) {
		Code.putJump(0);
		int pc = Code.pc -2;
		afterElseAddr = pc;
		
		listOfFalseJumps.forEach(elem->{
			Code.fixup(elem);
		});
		
		listOfFalseJumps.clear();
	}
	
	private int getOpNum(Relop relOp) {
		
		if(relOp instanceof IsEqualRelOp)
			return Code.eq;
		else if(relOp instanceof NotEqualRelOp)
			return Code.ne;
		else if(relOp instanceof LessRelOp)
			return Code.lt;
		else if(relOp instanceof GreaterRelOp)
			return Code.gt;
		else if(relOp instanceof LessEqRelOp)
			return Code.le;
		else if(relOp instanceof GreaterEqRelOp)
			return Code.ge;
		
		return 0;
	}
	
	
	//****************************** CONDITIONS **********************************
	public void visit(CondFactorSingle condFactor) {
		Code.loadConst(0);
		Code.putFalseJump(Code.ne, 0); // filler code, to leave space for later
		int addr = Code.pc - 2;
		listOfFalseJumps.add(addr);
	}
	public void visit(CondFactorMulti condFactor) {
		Code.putFalseJump(getOpNum(condFactor.getRelop()), 0); // filler code, to leave space for later
		int addr = Code.pc - 2;
		listOfFalseJumps.add(addr);
	}
	public void visit(ConditionOr or) {
		Code.putJump(0);
		int addr = Code.pc - 2;
		listOfOrJumps.add(addr);
		
		listOfFalseJumps.forEach(elem->{
			Code.fixup(elem);
		});
		
		listOfFalseJumps.clear();
	}
	
	
	//********************************* FUN CALL *************************************
	public void visit(MethodHeader methHeader) {

		if(methHeader.getMethName().equals("main") ) {
    		mainPc = Code.pc;
    	}    	
		methHeader.obj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(0);											//formalParams
		Code.put(methHeader.obj.getLocalSymbols().size());		//Number of locals
		
	}
	 public void visit(MethodDeclaration methDecl) {
    	Code.put(Code.exit);
    	Code.put(Code.return_);
    }
	// ********************************** PRINT  *************************************
	public void visit(PrintStatemtDetail print) {
		Struct exprStruct = print.getExpr().struct;
		int currtype = Struct.None;
		// Array Check
		if (exprStruct.getElemType() == null) {
			currtype = exprStruct.getKind();
		} else {
			currtype = exprStruct.getElemType().getKind();
		}

		if (print.getPrintStmtOpt() instanceof PrintStatementOption) {
			// Imamo zadat parametar sirine
			int width = ((NumberConstant) ((PrintStatementOption) print.getPrintStmtOpt()).getNumConst()).getN1();
			Code.loadConst(width);
			if (currtype == Struct.Int) {
				Code.put(Code.print);
			} else { // Bool, char
				Code.put(Code.bprint);
			}

		} else {
			if (currtype == Struct.Int) {
				Code.loadConst(5);
				Code.put(Code.print);
			} else { // Bool, char
				Code.loadConst(1);
				Code.put(Code.bprint);
			}
		}
		
	}
	//*********************************** READ *******************************************
	public void visit(ReadStatementDetail read) {
    	//read.obj = read.getDesignator().obj;
    	Struct desStrcut =  read.getDesignator().obj.getType();
    	
    	int currtype = Struct.None;
    	if(desStrcut.getElemType() == null) {
    		currtype = desStrcut.getKind();
    	}else{
    		currtype = desStrcut.getElemType().getKind();
    	}
    	
    	if(currtype == Struct.Int) {
    		Code.put(Code.read);	//word
    	}else {	
    		Code.put(Code.bread);	//byte
    	}
    	Code.store(read.getDesignator().obj);
	}
}

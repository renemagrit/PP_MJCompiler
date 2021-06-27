package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.*;

public class CodeGenerator extends VisitorAdaptor {
	private int mainPc;
	
	public int getMainPc() {
		return mainPc;
	}
	
	public void visit(FactorNumConst numConst) {
	   int constValue = ((NumberConstant)numConst.getNumConst()).getN1();
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
	
	   
	public void visit(PrintStatemtDetail print) {
		Struct exprStruct = print.getExpr().struct;	
		int currtype = Struct.None;
    	//Array Check
		if(exprStruct.getElemType() == null) {
    		currtype = exprStruct.getKind();
    	}else{
    		currtype = exprStruct.getElemType().getKind();
    	}	
    	
		
		if(print.getPrintStmtOpt() instanceof PrintStatementOption) {
			// Imamo zadat parametar sirine
			int width = ((NumberConstant)((PrintStatementOption)print.getPrintStmtOpt()).getNumConst()).getN1();
			Code.loadConst(width);
			if(currtype == Struct.Int) {
	    		Code.put(Code.print);
	    	}else { //Bool, char
	    		Code.put(Code.bprint);
	    	}
			
		}else {
			if(currtype == Struct.Int) {
	    		Code.loadConst(5);
	    		Code.put(Code.print);
	    	}else { //Bool, char
	    		Code.loadConst(1);
	    		Code.put(Code.bprint);
	    	}
		}		
		Code.put(Code.return_);
	 }
}

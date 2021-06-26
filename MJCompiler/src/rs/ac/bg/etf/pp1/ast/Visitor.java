// generated with ast extension for cup
// version 0.8
// 26/5/2021 20:42:7


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(ReturnStmt ReturnStmt);
    public void visit(ActParsExprList ActParsExprList);
    public void visit(RepeatMethodDecl RepeatMethodDecl);
    public void visit(ProgramDeclarationListValue ProgramDeclarationListValue);
    public void visit(MethodDecl MethodDecl);
    public void visit(Mulop Mulop);
    public void visit(DefaulStmt DefaulStmt);
    public void visit(Relop Relop);
    public void visit(Assignop Assignop);
    public void visit(CharConst charConst);
    public void visit(DoWhileStmt DoWhileStmt);
    public void visit(PrintStmt PrintStmt);
    public void visit(ActParsDetail ActParsDetail);
    public void visit(ProgramDeclarationList ProgramDeclarationList);
    public void visit(BoolConst boolConst);
    public void visit(DesigantorList DesigantorList);
    public void visit(ReadStmt ReadStmt);
    public void visit(FromParamsVal FromParamsVal);
    public void visit(Addop Addop);
    public void visit(ListStatementOpt ListStatementOpt);
    public void visit(Factor Factor);
    public void visit(CondTerm CondTerm);
    public void visit(DesignatorActPars DesignatorActPars);
    public void visit(GlobalVarDecl GlobalVarDecl);
    public void visit(Term Term);
    public void visit(Condition Condition);
    public void visit(ExprListVal ExprListVal);
    public void visit(MethodDeclType MethodDeclType);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(FromParamsList FromParamsList);
    public void visit(FromParams FromParams);
    public void visit(ElseStatement ElseStatement);
    public void visit(PrintStmtOpt PrintStmtOpt);
    public void visit(ExprList ExprList);
    public void visit(YieldStmt YieldStmt);
    public void visit(NegPrefix NegPrefix);
    public void visit(ExprFactorOpt ExprFactorOpt);
    public void visit(SwitchStmtList SwitchStmtList);
    public void visit(ConstOption ConstOption);
    public void visit(VarDeclList VarDeclList);
    public void visit(SwitchStmtBody SwitchStmtBody);
    public void visit(SwitchStmtVal SwitchStmtVal);
    public void visit(Expr Expr);
    public void visit(ConstVal ConstVal);
    public void visit(ConditionStmt ConditionStmt);
    public void visit(ActPars ActPars);
    public void visit(MethodDelVarList MethodDelVarList);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(TermRepeat TermRepeat);
    public void visit(Statement Statement);
    public void visit(VarDecl VarDecl);
    public void visit(ReturnExpr ReturnExpr);
    public void visit(ClassDecl ClassDecl);
    public void visit(ConstDecl ConstDecl);
    public void visit(CondFact CondFact);
    public void visit(VarVal VarVal);
    public void visit(BrackArrayList BrackArrayList);
    public void visit(NumConst numConst);
    public void visit(SwitchStmt SwitchStmt);
    public void visit(AssignOpExpr AssignOpExpr);
    public void visit(NoBrackArrayList NoBrackArrayList);
    public void visit(BrackArrayLst BrackArrayLst);
    public void visit(Type Type);
    public void visit(ConstOptionChar ConstOptionChar);
    public void visit(ConstOptionBool ConstOptionBool);
    public void visit(ConstOptionNumber ConstOptionNumber);
    public void visit(CharConstant CharConstant);
    public void visit(BoolConstant BoolConstant);
    public void visit(NumberConstant NumberConstant);
    public void visit(AssignOperator AssignOperator);
    public void visit(GreaterEqRelOp GreaterEqRelOp);
    public void visit(LessEqRelOp LessEqRelOp);
    public void visit(GreaterRelOp GreaterRelOp);
    public void visit(LessRelOp LessRelOp);
    public void visit(NotEqualRelOp NotEqualRelOp);
    public void visit(IsEqualRelOp IsEqualRelOp);
    public void visit(ModOption ModOption);
    public void visit(DivOption DivOption);
    public void visit(MulOption MulOption);
    public void visit(MinusOp MinusOp);
    public void visit(PlusOp PlusOp);
    public void visit(NoNegativePrefix NoNegativePrefix);
    public void visit(NegativePrefix NegativePrefix);
    public void visit(FacorExpression FacorExpression);
    public void visit(FactorNewType FactorNewType);
    public void visit(FactorBoolConst FactorBoolConst);
    public void visit(FactorCharConst FactorCharConst);
    public void visit(FactorNumConst FactorNumConst);
    public void visit(FactorFuncCall FactorFuncCall);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(NoMulOptTerm NoMulOptTerm);
    public void visit(MulOptTerm MulOptTerm);
    public void visit(BasicTerm BasicTerm);
    public void visit(NoExpressionFactorOption NoExpressionFactorOption);
    public void visit(ExpressionFactorOption ExpressionFactorOption);
    public void visit(ExpressionListValue ExpressionListValue);
    public void visit(NoExpressionList NoExpressionList);
    public void visit(ExpressionList ExpressionList);
    public void visit(SwitchStatement SwitchStatement);
    public void visit(Expression Expression);
    public void visit(CondFactorMulti CondFactorMulti);
    public void visit(CondFactorSingle CondFactorSingle);
    public void visit(SingleCondTerm SingleCondTerm);
    public void visit(MultiCondTerm MultiCondTerm);
    public void visit(SingleCondition SingleCondition);
    public void visit(MultiCondition MultiCondition);
    public void visit(ErrorCondition ErrorCondition);
    public void visit(ConditionStatemnt ConditionStatemnt);
    public void visit(NoDsgnList NoDsgnList);
    public void visit(DsgnList DsgnList);
    public void visit(Designator Designator);
    public void visit(ErrorAssignExpression ErrorAssignExpression);
    public void visit(AssignOpeeratorExpresion AssignOpeeratorExpresion);
    public void visit(FunctionCall FunctionCall);
    public void visit(DesignatorStatementDec DesignatorStatementDec);
    public void visit(DesignatorStatementInc DesignatorStatementInc);
    public void visit(DesignatorStatementFuncCall DesignatorStatementFuncCall);
    public void visit(DesignatorStatementAssign DesignatorStatementAssign);
    public void visit(SingleActParsExprList SingleActParsExprList);
    public void visit(ActParsExprListList ActParsExprListList);
    public void visit(ActualParameters ActualParameters);
    public void visit(NoActualParametersDetail NoActualParametersDetail);
    public void visit(ActualParametersDetail ActualParametersDetail);
    public void visit(YieldStatamentDetail YieldStatamentDetail);
    public void visit(NoPrintStatementOption NoPrintStatementOption);
    public void visit(PrintStatementOption PrintStatementOption);
    public void visit(PrintStatemtDetail PrintStatemtDetail);
    public void visit(ReadStatementDetail ReadStatementDetail);
    public void visit(NoReturnExpression NoReturnExpression);
    public void visit(ReturnExpression ReturnExpression);
    public void visit(ReturnStatementDetail ReturnStatementDetail);
    public void visit(NoDefaultStatement NoDefaultStatement);
    public void visit(DefaultStatement DefaultStatement);
    public void visit(SwitchStatementValue SwitchStatementValue);
    public void visit(SingleSwitchStatement SingleSwitchStatement);
    public void visit(SwitchStatementList SwitchStatementList);
    public void visit(SwitchStatmentBody SwitchStatmentBody);
    public void visit(SwitchStatementDetail SwitchStatementDetail);
    public void visit(DoWhileStatementDetail DoWhileStatementDetail);
    public void visit(NoElseStatement NoElseStatement);
    public void visit(ElseStatements ElseStatements);
    public void visit(IfStatement IfStatement);
    public void visit(NoStatementListOpt NoStatementListOpt);
    public void visit(StatementListOpt StatementListOpt);
    public void visit(DetailStatement DetailStatement);
    public void visit(PrintStatement PrintStatement);
    public void visit(ReadStatement ReadStatement);
    public void visit(ReturnStatement ReturnStatement);
    public void visit(ContinueStatement ContinueStatement);
    public void visit(BreakStatement BreakStatement);
    public void visit(YieldStatment YieldStatment);
    public void visit(DoWhileStatement DoWhileStatement);
    public void visit(IfDetalStatement IfDetalStatement);
    public void visit(DesStatement DesStatement);
    public void visit(ErrorFormalParamesComma ErrorFormalParamesComma);
    public void visit(FromParamsValue FromParamsValue);
    public void visit(SingleFormParams SingleFormParams);
    public void visit(MultiFormParams MultiFormParams);
    public void visit(NoFromParameters NoFromParameters);
    public void visit(FromParameters FromParameters);
    public void visit(FormParamsEnd FormParamsEnd);
    public void visit(FormParamsBegin FormParamsBegin);
    public void visit(NoMethodDelVarList NoMethodDelVarList);
    public void visit(MultiMethodDelVarList MultiMethodDelVarList);
    public void visit(VoidMethodDeclType VoidMethodDeclType);
    public void visit(CustomMethodDeclType CustomMethodDeclType);
    public void visit(MethodHeader MethodHeader);
    public void visit(MethodDeclaration MethodDeclaration);
    public void visit(NoRepeatMethodDeclaration NoRepeatMethodDeclaration);
    public void visit(RepeatMethodDeclaration RepeatMethodDeclaration);
    public void visit(ClassDeclaration ClassDeclaration);
    public void visit(VarValue VarValue);
    public void visit(SingleVarDeclaration SingleVarDeclaration);
    public void visit(VarDeclarationList VarDeclarationList);
    public void visit(ErrorVarGlobalDeclarationComma ErrorVarGlobalDeclarationComma);
    public void visit(ErrorVarGlobalDeclarationSemi ErrorVarGlobalDeclarationSemi);
    public void visit(VarDeclaration VarDeclaration);
    public void visit(ConstValue ConstValue);
    public void visit(SingleConstDeclaration SingleConstDeclaration);
    public void visit(ConstDeckarationList ConstDeckarationList);
    public void visit(ErrorConstGlobalDeclarationComma ErrorConstGlobalDeclarationComma);
    public void visit(ErrorConstGlobalDeclarationSemi ErrorConstGlobalDeclarationSemi);
    public void visit(ConstDeclaration ConstDeclaration);
    public void visit(VarProgramDeclaration VarProgramDeclaration);
    public void visit(ConstProgramDeclaration ConstProgramDeclaration);
    public void visit(NoDecl NoDecl);
    public void visit(MultiProgramDeclarationList MultiProgramDeclarationList);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}

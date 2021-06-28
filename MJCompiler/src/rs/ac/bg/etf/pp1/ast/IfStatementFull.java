// generated with ast extension for cup
// version 0.8
// 28/5/2021 22:32:21


package rs.ac.bg.etf.pp1.ast;

public class IfStatementFull extends IfStatement {

    private IfDetected IfDetected;
    private ConditionStmt ConditionStmt;
    private Statement Statement;
    private ElseStatement ElseStatement;

    public IfStatementFull (IfDetected IfDetected, ConditionStmt ConditionStmt, Statement Statement, ElseStatement ElseStatement) {
        this.IfDetected=IfDetected;
        if(IfDetected!=null) IfDetected.setParent(this);
        this.ConditionStmt=ConditionStmt;
        if(ConditionStmt!=null) ConditionStmt.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.ElseStatement=ElseStatement;
        if(ElseStatement!=null) ElseStatement.setParent(this);
    }

    public IfDetected getIfDetected() {
        return IfDetected;
    }

    public void setIfDetected(IfDetected IfDetected) {
        this.IfDetected=IfDetected;
    }

    public ConditionStmt getConditionStmt() {
        return ConditionStmt;
    }

    public void setConditionStmt(ConditionStmt ConditionStmt) {
        this.ConditionStmt=ConditionStmt;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public ElseStatement getElseStatement() {
        return ElseStatement;
    }

    public void setElseStatement(ElseStatement ElseStatement) {
        this.ElseStatement=ElseStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfDetected!=null) IfDetected.accept(visitor);
        if(ConditionStmt!=null) ConditionStmt.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(ElseStatement!=null) ElseStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfDetected!=null) IfDetected.traverseTopDown(visitor);
        if(ConditionStmt!=null) ConditionStmt.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(ElseStatement!=null) ElseStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfDetected!=null) IfDetected.traverseBottomUp(visitor);
        if(ConditionStmt!=null) ConditionStmt.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(ElseStatement!=null) ElseStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfStatementFull(\n");

        if(IfDetected!=null)
            buffer.append(IfDetected.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionStmt!=null)
            buffer.append(ConditionStmt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ElseStatement!=null)
            buffer.append(ElseStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfStatementFull]");
        return buffer.toString();
    }
}

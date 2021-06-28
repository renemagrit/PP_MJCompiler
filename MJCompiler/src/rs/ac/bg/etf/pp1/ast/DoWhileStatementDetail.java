// generated with ast extension for cup
// version 0.8
// 28/5/2021 10:40:43


package rs.ac.bg.etf.pp1.ast;

public class DoWhileStatementDetail extends DoWhileStmt {

    private Statement Statement;
    private ConditionStmt ConditionStmt;

    public DoWhileStatementDetail (Statement Statement, ConditionStmt ConditionStmt) {
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.ConditionStmt=ConditionStmt;
        if(ConditionStmt!=null) ConditionStmt.setParent(this);
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public ConditionStmt getConditionStmt() {
        return ConditionStmt;
    }

    public void setConditionStmt(ConditionStmt ConditionStmt) {
        this.ConditionStmt=ConditionStmt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Statement!=null) Statement.accept(visitor);
        if(ConditionStmt!=null) ConditionStmt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(ConditionStmt!=null) ConditionStmt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(ConditionStmt!=null) ConditionStmt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DoWhileStatementDetail(\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionStmt!=null)
            buffer.append(ConditionStmt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DoWhileStatementDetail]");
        return buffer.toString();
    }
}

// generated with ast extension for cup
// version 0.8
// 22/5/2021 19:58:41


package rs.ac.bg.etf.pp1.ast;

public class DoWhileStatement extends Statement {

    private DoWhileStmt DoWhileStmt;

    public DoWhileStatement (DoWhileStmt DoWhileStmt) {
        this.DoWhileStmt=DoWhileStmt;
        if(DoWhileStmt!=null) DoWhileStmt.setParent(this);
    }

    public DoWhileStmt getDoWhileStmt() {
        return DoWhileStmt;
    }

    public void setDoWhileStmt(DoWhileStmt DoWhileStmt) {
        this.DoWhileStmt=DoWhileStmt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DoWhileStmt!=null) DoWhileStmt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DoWhileStmt!=null) DoWhileStmt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DoWhileStmt!=null) DoWhileStmt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DoWhileStatement(\n");

        if(DoWhileStmt!=null)
            buffer.append(DoWhileStmt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DoWhileStatement]");
        return buffer.toString();
    }
}

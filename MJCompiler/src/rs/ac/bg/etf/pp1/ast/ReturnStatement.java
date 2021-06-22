// generated with ast extension for cup
// version 0.8
// 22/5/2021 17:43:35


package rs.ac.bg.etf.pp1.ast;

public class ReturnStatement extends Statement {

    private ReturnStmt ReturnStmt;

    public ReturnStatement (ReturnStmt ReturnStmt) {
        this.ReturnStmt=ReturnStmt;
        if(ReturnStmt!=null) ReturnStmt.setParent(this);
    }

    public ReturnStmt getReturnStmt() {
        return ReturnStmt;
    }

    public void setReturnStmt(ReturnStmt ReturnStmt) {
        this.ReturnStmt=ReturnStmt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ReturnStmt!=null) ReturnStmt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReturnStmt!=null) ReturnStmt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReturnStmt!=null) ReturnStmt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ReturnStatement(\n");

        if(ReturnStmt!=null)
            buffer.append(ReturnStmt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ReturnStatement]");
        return buffer.toString();
    }
}

// generated with ast extension for cup
// version 0.8
// 28/5/2021 13:43:32


package rs.ac.bg.etf.pp1.ast;

public class ReadStatement extends Statement {

    private ReadStmt ReadStmt;

    public ReadStatement (ReadStmt ReadStmt) {
        this.ReadStmt=ReadStmt;
        if(ReadStmt!=null) ReadStmt.setParent(this);
    }

    public ReadStmt getReadStmt() {
        return ReadStmt;
    }

    public void setReadStmt(ReadStmt ReadStmt) {
        this.ReadStmt=ReadStmt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ReadStmt!=null) ReadStmt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReadStmt!=null) ReadStmt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReadStmt!=null) ReadStmt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ReadStatement(\n");

        if(ReadStmt!=null)
            buffer.append(ReadStmt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ReadStatement]");
        return buffer.toString();
    }
}

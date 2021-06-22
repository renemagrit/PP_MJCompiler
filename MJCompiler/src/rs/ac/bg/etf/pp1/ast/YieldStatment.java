// generated with ast extension for cup
// version 0.8
// 22/5/2021 19:58:41


package rs.ac.bg.etf.pp1.ast;

public class YieldStatment extends Statement {

    private YieldStmt YieldStmt;

    public YieldStatment (YieldStmt YieldStmt) {
        this.YieldStmt=YieldStmt;
        if(YieldStmt!=null) YieldStmt.setParent(this);
    }

    public YieldStmt getYieldStmt() {
        return YieldStmt;
    }

    public void setYieldStmt(YieldStmt YieldStmt) {
        this.YieldStmt=YieldStmt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(YieldStmt!=null) YieldStmt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(YieldStmt!=null) YieldStmt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(YieldStmt!=null) YieldStmt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("YieldStatment(\n");

        if(YieldStmt!=null)
            buffer.append(YieldStmt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [YieldStatment]");
        return buffer.toString();
    }
}

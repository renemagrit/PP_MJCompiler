// generated with ast extension for cup
// version 0.8
// 23/5/2021 0:3:27


package rs.ac.bg.etf.pp1.ast;

public class SwitchStatement extends Expr {

    private SwitchStmt SwitchStmt;

    public SwitchStatement (SwitchStmt SwitchStmt) {
        this.SwitchStmt=SwitchStmt;
        if(SwitchStmt!=null) SwitchStmt.setParent(this);
    }

    public SwitchStmt getSwitchStmt() {
        return SwitchStmt;
    }

    public void setSwitchStmt(SwitchStmt SwitchStmt) {
        this.SwitchStmt=SwitchStmt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SwitchStmt!=null) SwitchStmt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SwitchStmt!=null) SwitchStmt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SwitchStmt!=null) SwitchStmt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SwitchStatement(\n");

        if(SwitchStmt!=null)
            buffer.append(SwitchStmt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SwitchStatement]");
        return buffer.toString();
    }
}

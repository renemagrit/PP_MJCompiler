// generated with ast extension for cup
// version 0.8
// 26/5/2021 23:42:34


package rs.ac.bg.etf.pp1.ast;

public class SingleSwitchStatement extends SwitchStmtList {

    private SwitchStmtVal SwitchStmtVal;

    public SingleSwitchStatement (SwitchStmtVal SwitchStmtVal) {
        this.SwitchStmtVal=SwitchStmtVal;
        if(SwitchStmtVal!=null) SwitchStmtVal.setParent(this);
    }

    public SwitchStmtVal getSwitchStmtVal() {
        return SwitchStmtVal;
    }

    public void setSwitchStmtVal(SwitchStmtVal SwitchStmtVal) {
        this.SwitchStmtVal=SwitchStmtVal;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SwitchStmtVal!=null) SwitchStmtVal.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SwitchStmtVal!=null) SwitchStmtVal.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SwitchStmtVal!=null) SwitchStmtVal.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleSwitchStatement(\n");

        if(SwitchStmtVal!=null)
            buffer.append(SwitchStmtVal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleSwitchStatement]");
        return buffer.toString();
    }
}

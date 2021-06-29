// generated with ast extension for cup
// version 0.8
// 29/5/2021 14:44:45


package rs.ac.bg.etf.pp1.ast;

public class SwitchStatementList extends SwitchStmtList {

    private SwitchStmtList SwitchStmtList;
    private SwitchStmtVal SwitchStmtVal;

    public SwitchStatementList (SwitchStmtList SwitchStmtList, SwitchStmtVal SwitchStmtVal) {
        this.SwitchStmtList=SwitchStmtList;
        if(SwitchStmtList!=null) SwitchStmtList.setParent(this);
        this.SwitchStmtVal=SwitchStmtVal;
        if(SwitchStmtVal!=null) SwitchStmtVal.setParent(this);
    }

    public SwitchStmtList getSwitchStmtList() {
        return SwitchStmtList;
    }

    public void setSwitchStmtList(SwitchStmtList SwitchStmtList) {
        this.SwitchStmtList=SwitchStmtList;
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
        if(SwitchStmtList!=null) SwitchStmtList.accept(visitor);
        if(SwitchStmtVal!=null) SwitchStmtVal.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SwitchStmtList!=null) SwitchStmtList.traverseTopDown(visitor);
        if(SwitchStmtVal!=null) SwitchStmtVal.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SwitchStmtList!=null) SwitchStmtList.traverseBottomUp(visitor);
        if(SwitchStmtVal!=null) SwitchStmtVal.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SwitchStatementList(\n");

        if(SwitchStmtList!=null)
            buffer.append(SwitchStmtList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SwitchStmtVal!=null)
            buffer.append(SwitchStmtVal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SwitchStatementList]");
        return buffer.toString();
    }
}

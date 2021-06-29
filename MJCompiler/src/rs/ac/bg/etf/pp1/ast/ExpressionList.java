// generated with ast extension for cup
// version 0.8
// 29/5/2021 11:52:6


package rs.ac.bg.etf.pp1.ast;

public class ExpressionList extends ExprList {

    private ExprList ExprList;
    private ExprListVal ExprListVal;

    public ExpressionList (ExprList ExprList, ExprListVal ExprListVal) {
        this.ExprList=ExprList;
        if(ExprList!=null) ExprList.setParent(this);
        this.ExprListVal=ExprListVal;
        if(ExprListVal!=null) ExprListVal.setParent(this);
    }

    public ExprList getExprList() {
        return ExprList;
    }

    public void setExprList(ExprList ExprList) {
        this.ExprList=ExprList;
    }

    public ExprListVal getExprListVal() {
        return ExprListVal;
    }

    public void setExprListVal(ExprListVal ExprListVal) {
        this.ExprListVal=ExprListVal;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprList!=null) ExprList.accept(visitor);
        if(ExprListVal!=null) ExprListVal.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprList!=null) ExprList.traverseTopDown(visitor);
        if(ExprListVal!=null) ExprListVal.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprList!=null) ExprList.traverseBottomUp(visitor);
        if(ExprListVal!=null) ExprListVal.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExpressionList(\n");

        if(ExprList!=null)
            buffer.append(ExprList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprListVal!=null)
            buffer.append(ExprListVal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExpressionList]");
        return buffer.toString();
    }
}

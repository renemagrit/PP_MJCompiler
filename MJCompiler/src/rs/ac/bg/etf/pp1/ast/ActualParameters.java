// generated with ast extension for cup
// version 0.8
// 29/5/2021 14:44:46


package rs.ac.bg.etf.pp1.ast;

public class ActualParameters extends ActPars {

    private ActParsExprList ActParsExprList;

    public ActualParameters (ActParsExprList ActParsExprList) {
        this.ActParsExprList=ActParsExprList;
        if(ActParsExprList!=null) ActParsExprList.setParent(this);
    }

    public ActParsExprList getActParsExprList() {
        return ActParsExprList;
    }

    public void setActParsExprList(ActParsExprList ActParsExprList) {
        this.ActParsExprList=ActParsExprList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParsExprList!=null) ActParsExprList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsExprList!=null) ActParsExprList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsExprList!=null) ActParsExprList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActualParameters(\n");

        if(ActParsExprList!=null)
            buffer.append(ActParsExprList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActualParameters]");
        return buffer.toString();
    }
}

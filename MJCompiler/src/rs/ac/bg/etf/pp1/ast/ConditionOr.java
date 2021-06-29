// generated with ast extension for cup
// version 0.8
// 29/5/2021 14:44:47


package rs.ac.bg.etf.pp1.ast;

public class ConditionOr extends CondOr {

    public ConditionOr () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionOr(\n");

        buffer.append(tab);
        buffer.append(") [ConditionOr]");
        return buffer.toString();
    }
}

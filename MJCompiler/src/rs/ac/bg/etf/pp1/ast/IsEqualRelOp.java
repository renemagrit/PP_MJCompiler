// generated with ast extension for cup
// version 0.8
// 26/5/2021 15:3:40


package rs.ac.bg.etf.pp1.ast;

public class IsEqualRelOp extends Relop {

    public IsEqualRelOp () {
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
        buffer.append("IsEqualRelOp(\n");

        buffer.append(tab);
        buffer.append(") [IsEqualRelOp]");
        return buffer.toString();
    }
}

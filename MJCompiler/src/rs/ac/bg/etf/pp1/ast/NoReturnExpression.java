// generated with ast extension for cup
// version 0.8
// 25/5/2021 19:20:10


package rs.ac.bg.etf.pp1.ast;

public class NoReturnExpression extends ReturnExpr {

    public NoReturnExpression () {
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
        buffer.append("NoReturnExpression(\n");

        buffer.append(tab);
        buffer.append(") [NoReturnExpression]");
        return buffer.toString();
    }
}

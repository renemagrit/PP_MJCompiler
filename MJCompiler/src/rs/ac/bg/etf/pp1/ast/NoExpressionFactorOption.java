// generated with ast extension for cup
// version 0.8
// 22/5/2021 17:43:35


package rs.ac.bg.etf.pp1.ast;

public class NoExpressionFactorOption extends ExprFactorOpt {

    public NoExpressionFactorOption () {
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
        buffer.append("NoExpressionFactorOption(\n");

        buffer.append(tab);
        buffer.append(") [NoExpressionFactorOption]");
        return buffer.toString();
    }
}

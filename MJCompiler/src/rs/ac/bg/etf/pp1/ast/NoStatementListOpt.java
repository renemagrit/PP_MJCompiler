// generated with ast extension for cup
// version 0.8
// 26/5/2021 20:42:7


package rs.ac.bg.etf.pp1.ast;

public class NoStatementListOpt extends ListStatementOpt {

    public NoStatementListOpt () {
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
        buffer.append("NoStatementListOpt(\n");

        buffer.append(tab);
        buffer.append(") [NoStatementListOpt]");
        return buffer.toString();
    }
}

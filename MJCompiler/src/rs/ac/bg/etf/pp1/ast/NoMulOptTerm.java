// generated with ast extension for cup
// version 0.8
// 28/5/2021 14:24:23


package rs.ac.bg.etf.pp1.ast;

public class NoMulOptTerm extends TermRepeat {

    public NoMulOptTerm () {
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
        buffer.append("NoMulOptTerm(\n");

        buffer.append(tab);
        buffer.append(") [NoMulOptTerm]");
        return buffer.toString();
    }
}

// generated with ast extension for cup
// version 0.8
// 28/5/2021 14:4:42


package rs.ac.bg.etf.pp1.ast;

public class NoDsgnList extends DesigantorList {

    public NoDsgnList () {
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
        buffer.append("NoDsgnList(\n");

        buffer.append(tab);
        buffer.append(") [NoDsgnList]");
        return buffer.toString();
    }
}

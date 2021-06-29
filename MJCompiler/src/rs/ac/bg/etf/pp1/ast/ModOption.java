// generated with ast extension for cup
// version 0.8
// 29/5/2021 14:44:48


package rs.ac.bg.etf.pp1.ast;

public class ModOption extends Mulop {

    public ModOption () {
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
        buffer.append("ModOption(\n");

        buffer.append(tab);
        buffer.append(") [ModOption]");
        return buffer.toString();
    }
}

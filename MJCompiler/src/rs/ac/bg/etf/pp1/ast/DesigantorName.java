// generated with ast extension for cup
// version 0.8
// 29/5/2021 14:44:46


package rs.ac.bg.etf.pp1.ast;

public class DesigantorName extends DesName {

    private String desigantorName;

    public DesigantorName (String desigantorName) {
        this.desigantorName=desigantorName;
    }

    public String getDesigantorName() {
        return desigantorName;
    }

    public void setDesigantorName(String desigantorName) {
        this.desigantorName=desigantorName;
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
        buffer.append("DesigantorName(\n");

        buffer.append(" "+tab+desigantorName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesigantorName]");
        return buffer.toString();
    }
}

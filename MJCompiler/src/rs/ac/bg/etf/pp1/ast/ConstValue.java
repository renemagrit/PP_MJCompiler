// generated with ast extension for cup
// version 0.8
// 22/5/2021 18:56:41


package rs.ac.bg.etf.pp1.ast;

public class ConstValue extends ConstVal {

    private String constName;
    private ConstOption ConstOption;

    public ConstValue (String constName, ConstOption ConstOption) {
        this.constName=constName;
        this.ConstOption=ConstOption;
        if(ConstOption!=null) ConstOption.setParent(this);
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName=constName;
    }

    public ConstOption getConstOption() {
        return ConstOption;
    }

    public void setConstOption(ConstOption ConstOption) {
        this.ConstOption=ConstOption;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstOption!=null) ConstOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstOption!=null) ConstOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstOption!=null) ConstOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstValue(\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        if(ConstOption!=null)
            buffer.append(ConstOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstValue]");
        return buffer.toString();
    }
}

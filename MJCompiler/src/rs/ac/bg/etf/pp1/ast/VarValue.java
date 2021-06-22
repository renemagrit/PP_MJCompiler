// generated with ast extension for cup
// version 0.8
// 22/5/2021 19:58:41


package rs.ac.bg.etf.pp1.ast;

public class VarValue extends VarVal {

    private String varName;
    private BrackArrayList BrackArrayList;

    public VarValue (String varName, BrackArrayList BrackArrayList) {
        this.varName=varName;
        this.BrackArrayList=BrackArrayList;
        if(BrackArrayList!=null) BrackArrayList.setParent(this);
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public BrackArrayList getBrackArrayList() {
        return BrackArrayList;
    }

    public void setBrackArrayList(BrackArrayList BrackArrayList) {
        this.BrackArrayList=BrackArrayList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(BrackArrayList!=null) BrackArrayList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BrackArrayList!=null) BrackArrayList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BrackArrayList!=null) BrackArrayList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarValue(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(BrackArrayList!=null)
            buffer.append(BrackArrayList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarValue]");
        return buffer.toString();
    }
}

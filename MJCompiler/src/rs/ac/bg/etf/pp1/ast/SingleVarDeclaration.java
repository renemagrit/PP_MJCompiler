// generated with ast extension for cup
// version 0.8
// 22/5/2021 18:56:41


package rs.ac.bg.etf.pp1.ast;

public class SingleVarDeclaration extends VarDeclList {

    private VarVal VarVal;

    public SingleVarDeclaration (VarVal VarVal) {
        this.VarVal=VarVal;
        if(VarVal!=null) VarVal.setParent(this);
    }

    public VarVal getVarVal() {
        return VarVal;
    }

    public void setVarVal(VarVal VarVal) {
        this.VarVal=VarVal;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarVal!=null) VarVal.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarVal!=null) VarVal.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarVal!=null) VarVal.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleVarDeclaration(\n");

        if(VarVal!=null)
            buffer.append(VarVal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleVarDeclaration]");
        return buffer.toString();
    }
}

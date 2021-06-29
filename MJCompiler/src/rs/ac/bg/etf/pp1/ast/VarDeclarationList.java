// generated with ast extension for cup
// version 0.8
// 29/5/2021 11:52:6


package rs.ac.bg.etf.pp1.ast;

public class VarDeclarationList extends VarDeclList {

    private VarDeclList VarDeclList;
    private VarVal VarVal;

    public VarDeclarationList (VarDeclList VarDeclList, VarVal VarVal) {
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.VarVal=VarVal;
        if(VarVal!=null) VarVal.setParent(this);
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
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
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(VarVal!=null) VarVal.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(VarVal!=null) VarVal.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(VarVal!=null) VarVal.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclarationList(\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarVal!=null)
            buffer.append(VarVal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclarationList]");
        return buffer.toString();
    }
}

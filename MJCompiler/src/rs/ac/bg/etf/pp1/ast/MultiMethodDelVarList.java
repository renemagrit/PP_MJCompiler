// generated with ast extension for cup
// version 0.8
// 26/5/2021 1:2:56


package rs.ac.bg.etf.pp1.ast;

public class MultiMethodDelVarList extends MethodDelVarList {

    private MethodDelVarList MethodDelVarList;
    private VarDecl VarDecl;

    public MultiMethodDelVarList (MethodDelVarList MethodDelVarList, VarDecl VarDecl) {
        this.MethodDelVarList=MethodDelVarList;
        if(MethodDelVarList!=null) MethodDelVarList.setParent(this);
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
    }

    public MethodDelVarList getMethodDelVarList() {
        return MethodDelVarList;
    }

    public void setMethodDelVarList(MethodDelVarList MethodDelVarList) {
        this.MethodDelVarList=MethodDelVarList;
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDelVarList!=null) MethodDelVarList.accept(visitor);
        if(VarDecl!=null) VarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDelVarList!=null) MethodDelVarList.traverseTopDown(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDelVarList!=null) MethodDelVarList.traverseBottomUp(visitor);
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultiMethodDelVarList(\n");

        if(MethodDelVarList!=null)
            buffer.append(MethodDelVarList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultiMethodDelVarList]");
        return buffer.toString();
    }
}

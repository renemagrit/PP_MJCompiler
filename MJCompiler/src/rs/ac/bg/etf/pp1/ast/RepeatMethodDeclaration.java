// generated with ast extension for cup
// version 0.8
// 28/5/2021 13:43:32


package rs.ac.bg.etf.pp1.ast;

public class RepeatMethodDeclaration extends RepeatMethodDecl {

    private RepeatMethodDecl RepeatMethodDecl;
    private MethodDecl MethodDecl;

    public RepeatMethodDeclaration (RepeatMethodDecl RepeatMethodDecl, MethodDecl MethodDecl) {
        this.RepeatMethodDecl=RepeatMethodDecl;
        if(RepeatMethodDecl!=null) RepeatMethodDecl.setParent(this);
        this.MethodDecl=MethodDecl;
        if(MethodDecl!=null) MethodDecl.setParent(this);
    }

    public RepeatMethodDecl getRepeatMethodDecl() {
        return RepeatMethodDecl;
    }

    public void setRepeatMethodDecl(RepeatMethodDecl RepeatMethodDecl) {
        this.RepeatMethodDecl=RepeatMethodDecl;
    }

    public MethodDecl getMethodDecl() {
        return MethodDecl;
    }

    public void setMethodDecl(MethodDecl MethodDecl) {
        this.MethodDecl=MethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(RepeatMethodDecl!=null) RepeatMethodDecl.accept(visitor);
        if(MethodDecl!=null) MethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RepeatMethodDecl!=null) RepeatMethodDecl.traverseTopDown(visitor);
        if(MethodDecl!=null) MethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RepeatMethodDecl!=null) RepeatMethodDecl.traverseBottomUp(visitor);
        if(MethodDecl!=null) MethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RepeatMethodDeclaration(\n");

        if(RepeatMethodDecl!=null)
            buffer.append(RepeatMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDecl!=null)
            buffer.append(MethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RepeatMethodDeclaration]");
        return buffer.toString();
    }
}

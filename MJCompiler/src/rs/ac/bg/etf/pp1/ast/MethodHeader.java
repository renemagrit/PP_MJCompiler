// generated with ast extension for cup
// version 0.8
// 26/5/2021 20:42:7


package rs.ac.bg.etf.pp1.ast;

public class MethodHeader implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private MethodDeclType MethodDeclType;
    private String methName;

    public MethodHeader (MethodDeclType MethodDeclType, String methName) {
        this.MethodDeclType=MethodDeclType;
        if(MethodDeclType!=null) MethodDeclType.setParent(this);
        this.methName=methName;
    }

    public MethodDeclType getMethodDeclType() {
        return MethodDeclType;
    }

    public void setMethodDeclType(MethodDeclType MethodDeclType) {
        this.MethodDeclType=MethodDeclType;
    }

    public String getMethName() {
        return methName;
    }

    public void setMethName(String methName) {
        this.methName=methName;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDeclType!=null) MethodDeclType.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDeclType!=null) MethodDeclType.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDeclType!=null) MethodDeclType.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodHeader(\n");

        if(MethodDeclType!=null)
            buffer.append(MethodDeclType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+methName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodHeader]");
        return buffer.toString();
    }
}

// generated with ast extension for cup
// version 0.8
// 29/5/2021 14:44:43


package rs.ac.bg.etf.pp1.ast;

public class Program implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private ProgName ProgName;
    private ProgramDeclarationList ProgramDeclarationList;
    private RepeatMethodDecl RepeatMethodDecl;

    public Program (ProgName ProgName, ProgramDeclarationList ProgramDeclarationList, RepeatMethodDecl RepeatMethodDecl) {
        this.ProgName=ProgName;
        if(ProgName!=null) ProgName.setParent(this);
        this.ProgramDeclarationList=ProgramDeclarationList;
        if(ProgramDeclarationList!=null) ProgramDeclarationList.setParent(this);
        this.RepeatMethodDecl=RepeatMethodDecl;
        if(RepeatMethodDecl!=null) RepeatMethodDecl.setParent(this);
    }

    public ProgName getProgName() {
        return ProgName;
    }

    public void setProgName(ProgName ProgName) {
        this.ProgName=ProgName;
    }

    public ProgramDeclarationList getProgramDeclarationList() {
        return ProgramDeclarationList;
    }

    public void setProgramDeclarationList(ProgramDeclarationList ProgramDeclarationList) {
        this.ProgramDeclarationList=ProgramDeclarationList;
    }

    public RepeatMethodDecl getRepeatMethodDecl() {
        return RepeatMethodDecl;
    }

    public void setRepeatMethodDecl(RepeatMethodDecl RepeatMethodDecl) {
        this.RepeatMethodDecl=RepeatMethodDecl;
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
        if(ProgName!=null) ProgName.accept(visitor);
        if(ProgramDeclarationList!=null) ProgramDeclarationList.accept(visitor);
        if(RepeatMethodDecl!=null) RepeatMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgName!=null) ProgName.traverseTopDown(visitor);
        if(ProgramDeclarationList!=null) ProgramDeclarationList.traverseTopDown(visitor);
        if(RepeatMethodDecl!=null) RepeatMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgName!=null) ProgName.traverseBottomUp(visitor);
        if(ProgramDeclarationList!=null) ProgramDeclarationList.traverseBottomUp(visitor);
        if(RepeatMethodDecl!=null) RepeatMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Program(\n");

        if(ProgName!=null)
            buffer.append(ProgName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ProgramDeclarationList!=null)
            buffer.append(ProgramDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RepeatMethodDecl!=null)
            buffer.append(RepeatMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Program]");
        return buffer.toString();
    }
}

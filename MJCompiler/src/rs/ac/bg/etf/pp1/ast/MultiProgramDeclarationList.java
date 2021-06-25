// generated with ast extension for cup
// version 0.8
// 26/5/2021 1:2:56


package rs.ac.bg.etf.pp1.ast;

public class MultiProgramDeclarationList extends ProgramDeclarationList {

    private ProgramDeclarationList ProgramDeclarationList;
    private ProgramDeclarationListValue ProgramDeclarationListValue;

    public MultiProgramDeclarationList (ProgramDeclarationList ProgramDeclarationList, ProgramDeclarationListValue ProgramDeclarationListValue) {
        this.ProgramDeclarationList=ProgramDeclarationList;
        if(ProgramDeclarationList!=null) ProgramDeclarationList.setParent(this);
        this.ProgramDeclarationListValue=ProgramDeclarationListValue;
        if(ProgramDeclarationListValue!=null) ProgramDeclarationListValue.setParent(this);
    }

    public ProgramDeclarationList getProgramDeclarationList() {
        return ProgramDeclarationList;
    }

    public void setProgramDeclarationList(ProgramDeclarationList ProgramDeclarationList) {
        this.ProgramDeclarationList=ProgramDeclarationList;
    }

    public ProgramDeclarationListValue getProgramDeclarationListValue() {
        return ProgramDeclarationListValue;
    }

    public void setProgramDeclarationListValue(ProgramDeclarationListValue ProgramDeclarationListValue) {
        this.ProgramDeclarationListValue=ProgramDeclarationListValue;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgramDeclarationList!=null) ProgramDeclarationList.accept(visitor);
        if(ProgramDeclarationListValue!=null) ProgramDeclarationListValue.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramDeclarationList!=null) ProgramDeclarationList.traverseTopDown(visitor);
        if(ProgramDeclarationListValue!=null) ProgramDeclarationListValue.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramDeclarationList!=null) ProgramDeclarationList.traverseBottomUp(visitor);
        if(ProgramDeclarationListValue!=null) ProgramDeclarationListValue.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultiProgramDeclarationList(\n");

        if(ProgramDeclarationList!=null)
            buffer.append(ProgramDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ProgramDeclarationListValue!=null)
            buffer.append(ProgramDeclarationListValue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultiProgramDeclarationList]");
        return buffer.toString();
    }
}

// generated with ast extension for cup
// version 0.8
// 26/5/2021 19:18:3


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclaration extends MethodDecl {

    private MethodHeader MethodHeader;
    private FormParamsBegin FormParamsBegin;
    private FromParams FromParams;
    private FormParamsEnd FormParamsEnd;
    private MethodDelVarList MethodDelVarList;
    private ListStatementOpt ListStatementOpt;

    public MethodDeclaration (MethodHeader MethodHeader, FormParamsBegin FormParamsBegin, FromParams FromParams, FormParamsEnd FormParamsEnd, MethodDelVarList MethodDelVarList, ListStatementOpt ListStatementOpt) {
        this.MethodHeader=MethodHeader;
        if(MethodHeader!=null) MethodHeader.setParent(this);
        this.FormParamsBegin=FormParamsBegin;
        if(FormParamsBegin!=null) FormParamsBegin.setParent(this);
        this.FromParams=FromParams;
        if(FromParams!=null) FromParams.setParent(this);
        this.FormParamsEnd=FormParamsEnd;
        if(FormParamsEnd!=null) FormParamsEnd.setParent(this);
        this.MethodDelVarList=MethodDelVarList;
        if(MethodDelVarList!=null) MethodDelVarList.setParent(this);
        this.ListStatementOpt=ListStatementOpt;
        if(ListStatementOpt!=null) ListStatementOpt.setParent(this);
    }

    public MethodHeader getMethodHeader() {
        return MethodHeader;
    }

    public void setMethodHeader(MethodHeader MethodHeader) {
        this.MethodHeader=MethodHeader;
    }

    public FormParamsBegin getFormParamsBegin() {
        return FormParamsBegin;
    }

    public void setFormParamsBegin(FormParamsBegin FormParamsBegin) {
        this.FormParamsBegin=FormParamsBegin;
    }

    public FromParams getFromParams() {
        return FromParams;
    }

    public void setFromParams(FromParams FromParams) {
        this.FromParams=FromParams;
    }

    public FormParamsEnd getFormParamsEnd() {
        return FormParamsEnd;
    }

    public void setFormParamsEnd(FormParamsEnd FormParamsEnd) {
        this.FormParamsEnd=FormParamsEnd;
    }

    public MethodDelVarList getMethodDelVarList() {
        return MethodDelVarList;
    }

    public void setMethodDelVarList(MethodDelVarList MethodDelVarList) {
        this.MethodDelVarList=MethodDelVarList;
    }

    public ListStatementOpt getListStatementOpt() {
        return ListStatementOpt;
    }

    public void setListStatementOpt(ListStatementOpt ListStatementOpt) {
        this.ListStatementOpt=ListStatementOpt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodHeader!=null) MethodHeader.accept(visitor);
        if(FormParamsBegin!=null) FormParamsBegin.accept(visitor);
        if(FromParams!=null) FromParams.accept(visitor);
        if(FormParamsEnd!=null) FormParamsEnd.accept(visitor);
        if(MethodDelVarList!=null) MethodDelVarList.accept(visitor);
        if(ListStatementOpt!=null) ListStatementOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodHeader!=null) MethodHeader.traverseTopDown(visitor);
        if(FormParamsBegin!=null) FormParamsBegin.traverseTopDown(visitor);
        if(FromParams!=null) FromParams.traverseTopDown(visitor);
        if(FormParamsEnd!=null) FormParamsEnd.traverseTopDown(visitor);
        if(MethodDelVarList!=null) MethodDelVarList.traverseTopDown(visitor);
        if(ListStatementOpt!=null) ListStatementOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodHeader!=null) MethodHeader.traverseBottomUp(visitor);
        if(FormParamsBegin!=null) FormParamsBegin.traverseBottomUp(visitor);
        if(FromParams!=null) FromParams.traverseBottomUp(visitor);
        if(FormParamsEnd!=null) FormParamsEnd.traverseBottomUp(visitor);
        if(MethodDelVarList!=null) MethodDelVarList.traverseBottomUp(visitor);
        if(ListStatementOpt!=null) ListStatementOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclaration(\n");

        if(MethodHeader!=null)
            buffer.append(MethodHeader.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParamsBegin!=null)
            buffer.append(FormParamsBegin.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FromParams!=null)
            buffer.append(FromParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParamsEnd!=null)
            buffer.append(FormParamsEnd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDelVarList!=null)
            buffer.append(MethodDelVarList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListStatementOpt!=null)
            buffer.append(ListStatementOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclaration]");
        return buffer.toString();
    }
}

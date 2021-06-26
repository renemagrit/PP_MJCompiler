// generated with ast extension for cup
// version 0.8
// 26/5/2021 20:42:7


package rs.ac.bg.etf.pp1.ast;

public class SwitchStatementValue extends SwitchStmtVal {

    private NumConst numConst;
    private ListStatementOpt ListStatementOpt;

    public SwitchStatementValue (NumConst numConst, ListStatementOpt ListStatementOpt) {
        this.numConst=numConst;
        if(numConst!=null) numConst.setParent(this);
        this.ListStatementOpt=ListStatementOpt;
        if(ListStatementOpt!=null) ListStatementOpt.setParent(this);
    }

    public NumConst getNumConst() {
        return numConst;
    }

    public void setNumConst(NumConst numConst) {
        this.numConst=numConst;
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
        if(numConst!=null) numConst.accept(visitor);
        if(ListStatementOpt!=null) ListStatementOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(numConst!=null) numConst.traverseTopDown(visitor);
        if(ListStatementOpt!=null) ListStatementOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(numConst!=null) numConst.traverseBottomUp(visitor);
        if(ListStatementOpt!=null) ListStatementOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SwitchStatementValue(\n");

        if(numConst!=null)
            buffer.append(numConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListStatementOpt!=null)
            buffer.append(ListStatementOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SwitchStatementValue]");
        return buffer.toString();
    }
}

// generated with ast extension for cup
// version 0.8
// 27/5/2021 16:40:29


package rs.ac.bg.etf.pp1.ast;

public class DetailStatement extends Statement {

    private ListStatementOpt ListStatementOpt;

    public DetailStatement (ListStatementOpt ListStatementOpt) {
        this.ListStatementOpt=ListStatementOpt;
        if(ListStatementOpt!=null) ListStatementOpt.setParent(this);
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
        if(ListStatementOpt!=null) ListStatementOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListStatementOpt!=null) ListStatementOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListStatementOpt!=null) ListStatementOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DetailStatement(\n");

        if(ListStatementOpt!=null)
            buffer.append(ListStatementOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DetailStatement]");
        return buffer.toString();
    }
}

// generated with ast extension for cup
// version 0.8
// 27/5/2021 16:40:29


package rs.ac.bg.etf.pp1.ast;

public class StatementListOpt extends ListStatementOpt {

    private ListStatementOpt ListStatementOpt;
    private Statement Statement;

    public StatementListOpt (ListStatementOpt ListStatementOpt, Statement Statement) {
        this.ListStatementOpt=ListStatementOpt;
        if(ListStatementOpt!=null) ListStatementOpt.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public ListStatementOpt getListStatementOpt() {
        return ListStatementOpt;
    }

    public void setListStatementOpt(ListStatementOpt ListStatementOpt) {
        this.ListStatementOpt=ListStatementOpt;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListStatementOpt!=null) ListStatementOpt.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListStatementOpt!=null) ListStatementOpt.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListStatementOpt!=null) ListStatementOpt.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementListOpt(\n");

        if(ListStatementOpt!=null)
            buffer.append(ListStatementOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementListOpt]");
        return buffer.toString();
    }
}

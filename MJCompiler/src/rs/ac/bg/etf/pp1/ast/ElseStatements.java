// generated with ast extension for cup
// version 0.8
// 29/5/2021 11:52:6


package rs.ac.bg.etf.pp1.ast;

public class ElseStatements extends ElseStatement {

    private ElseDec ElseDec;
    private Statement Statement;

    public ElseStatements (ElseDec ElseDec, Statement Statement) {
        this.ElseDec=ElseDec;
        if(ElseDec!=null) ElseDec.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public ElseDec getElseDec() {
        return ElseDec;
    }

    public void setElseDec(ElseDec ElseDec) {
        this.ElseDec=ElseDec;
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
        if(ElseDec!=null) ElseDec.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ElseDec!=null) ElseDec.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ElseDec!=null) ElseDec.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ElseStatements(\n");

        if(ElseDec!=null)
            buffer.append(ElseDec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ElseStatements]");
        return buffer.toString();
    }
}

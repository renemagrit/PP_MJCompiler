// generated with ast extension for cup
// version 0.8
// 25/5/2021 19:20:10


package rs.ac.bg.etf.pp1.ast;

public class SwitchStatementDetail extends SwitchStmt {

    private Expr Expr;
    private SwitchStmtBody SwitchStmtBody;

    public SwitchStatementDetail (Expr Expr, SwitchStmtBody SwitchStmtBody) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.SwitchStmtBody=SwitchStmtBody;
        if(SwitchStmtBody!=null) SwitchStmtBody.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public SwitchStmtBody getSwitchStmtBody() {
        return SwitchStmtBody;
    }

    public void setSwitchStmtBody(SwitchStmtBody SwitchStmtBody) {
        this.SwitchStmtBody=SwitchStmtBody;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(SwitchStmtBody!=null) SwitchStmtBody.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(SwitchStmtBody!=null) SwitchStmtBody.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(SwitchStmtBody!=null) SwitchStmtBody.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SwitchStatementDetail(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SwitchStmtBody!=null)
            buffer.append(SwitchStmtBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SwitchStatementDetail]");
        return buffer.toString();
    }
}

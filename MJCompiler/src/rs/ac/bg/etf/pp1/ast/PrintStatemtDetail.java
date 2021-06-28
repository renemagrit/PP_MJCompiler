// generated with ast extension for cup
// version 0.8
// 28/5/2021 14:24:23


package rs.ac.bg.etf.pp1.ast;

public class PrintStatemtDetail extends PrintStmt {

    private Expr Expr;
    private PrintStmtOpt PrintStmtOpt;

    public PrintStatemtDetail (Expr Expr, PrintStmtOpt PrintStmtOpt) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.PrintStmtOpt=PrintStmtOpt;
        if(PrintStmtOpt!=null) PrintStmtOpt.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public PrintStmtOpt getPrintStmtOpt() {
        return PrintStmtOpt;
    }

    public void setPrintStmtOpt(PrintStmtOpt PrintStmtOpt) {
        this.PrintStmtOpt=PrintStmtOpt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(PrintStmtOpt!=null) PrintStmtOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(PrintStmtOpt!=null) PrintStmtOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(PrintStmtOpt!=null) PrintStmtOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintStatemtDetail(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(PrintStmtOpt!=null)
            buffer.append(PrintStmtOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintStatemtDetail]");
        return buffer.toString();
    }
}

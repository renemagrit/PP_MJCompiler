// generated with ast extension for cup
// version 0.8
// 22/5/2021 17:43:35


package rs.ac.bg.etf.pp1.ast;

public class Expression extends Expr {

    private NegPrefix NegPrefix;
    private Term Term;
    private ExprList ExprList;

    public Expression (NegPrefix NegPrefix, Term Term, ExprList ExprList) {
        this.NegPrefix=NegPrefix;
        if(NegPrefix!=null) NegPrefix.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.ExprList=ExprList;
        if(ExprList!=null) ExprList.setParent(this);
    }

    public NegPrefix getNegPrefix() {
        return NegPrefix;
    }

    public void setNegPrefix(NegPrefix NegPrefix) {
        this.NegPrefix=NegPrefix;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public ExprList getExprList() {
        return ExprList;
    }

    public void setExprList(ExprList ExprList) {
        this.ExprList=ExprList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NegPrefix!=null) NegPrefix.accept(visitor);
        if(Term!=null) Term.accept(visitor);
        if(ExprList!=null) ExprList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NegPrefix!=null) NegPrefix.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(ExprList!=null) ExprList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NegPrefix!=null) NegPrefix.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(ExprList!=null) ExprList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Expression(\n");

        if(NegPrefix!=null)
            buffer.append(NegPrefix.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprList!=null)
            buffer.append(ExprList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Expression]");
        return buffer.toString();
    }
}

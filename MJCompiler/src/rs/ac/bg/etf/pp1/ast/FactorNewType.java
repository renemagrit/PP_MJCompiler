// generated with ast extension for cup
// version 0.8
// 29/5/2021 11:52:6


package rs.ac.bg.etf.pp1.ast;

public class FactorNewType extends Factor {

    private Type Type;
    private ExprFactorOpt ExprFactorOpt;

    public FactorNewType (Type Type, ExprFactorOpt ExprFactorOpt) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ExprFactorOpt=ExprFactorOpt;
        if(ExprFactorOpt!=null) ExprFactorOpt.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ExprFactorOpt getExprFactorOpt() {
        return ExprFactorOpt;
    }

    public void setExprFactorOpt(ExprFactorOpt ExprFactorOpt) {
        this.ExprFactorOpt=ExprFactorOpt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ExprFactorOpt!=null) ExprFactorOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ExprFactorOpt!=null) ExprFactorOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ExprFactorOpt!=null) ExprFactorOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNewType(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprFactorOpt!=null)
            buffer.append(ExprFactorOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNewType]");
        return buffer.toString();
    }
}

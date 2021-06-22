// generated with ast extension for cup
// version 0.8
// 22/5/2021 17:43:35


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementActPart extends DesignatorStatement {

    private Designator Designator;
    private ActParsDetail ActParsDetail;

    public DesignatorStatementActPart (Designator Designator, ActParsDetail ActParsDetail) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ActParsDetail=ActParsDetail;
        if(ActParsDetail!=null) ActParsDetail.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ActParsDetail getActParsDetail() {
        return ActParsDetail;
    }

    public void setActParsDetail(ActParsDetail ActParsDetail) {
        this.ActParsDetail=ActParsDetail;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ActParsDetail!=null) ActParsDetail.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ActParsDetail!=null) ActParsDetail.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ActParsDetail!=null) ActParsDetail.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementActPart(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsDetail!=null)
            buffer.append(ActParsDetail.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementActPart]");
        return buffer.toString();
    }
}
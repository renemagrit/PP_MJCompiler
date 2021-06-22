// generated with ast extension for cup
// version 0.8
// 22/5/2021 19:58:41


package rs.ac.bg.etf.pp1.ast;

public class DesignatorActualParams extends DesignatorActPars {

    private ActParsDetail ActParsDetail;

    public DesignatorActualParams (ActParsDetail ActParsDetail) {
        this.ActParsDetail=ActParsDetail;
        if(ActParsDetail!=null) ActParsDetail.setParent(this);
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
        if(ActParsDetail!=null) ActParsDetail.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsDetail!=null) ActParsDetail.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsDetail!=null) ActParsDetail.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorActualParams(\n");

        if(ActParsDetail!=null)
            buffer.append(ActParsDetail.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorActualParams]");
        return buffer.toString();
    }
}

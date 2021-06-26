// generated with ast extension for cup
// version 0.8
// 26/5/2021 23:42:34


package rs.ac.bg.etf.pp1.ast;

public class SingleFormParams extends FromParamsList {

    private FromParamsVal FromParamsVal;

    public SingleFormParams (FromParamsVal FromParamsVal) {
        this.FromParamsVal=FromParamsVal;
        if(FromParamsVal!=null) FromParamsVal.setParent(this);
    }

    public FromParamsVal getFromParamsVal() {
        return FromParamsVal;
    }

    public void setFromParamsVal(FromParamsVal FromParamsVal) {
        this.FromParamsVal=FromParamsVal;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FromParamsVal!=null) FromParamsVal.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FromParamsVal!=null) FromParamsVal.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FromParamsVal!=null) FromParamsVal.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleFormParams(\n");

        if(FromParamsVal!=null)
            buffer.append(FromParamsVal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleFormParams]");
        return buffer.toString();
    }
}

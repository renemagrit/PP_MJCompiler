// generated with ast extension for cup
// version 0.8
// 26/5/2021 15:3:40


package rs.ac.bg.etf.pp1.ast;

public class MultiFormParams extends FromParamsList {

    private FromParamsList FromParamsList;
    private FromParamsVal FromParamsVal;

    public MultiFormParams (FromParamsList FromParamsList, FromParamsVal FromParamsVal) {
        this.FromParamsList=FromParamsList;
        if(FromParamsList!=null) FromParamsList.setParent(this);
        this.FromParamsVal=FromParamsVal;
        if(FromParamsVal!=null) FromParamsVal.setParent(this);
    }

    public FromParamsList getFromParamsList() {
        return FromParamsList;
    }

    public void setFromParamsList(FromParamsList FromParamsList) {
        this.FromParamsList=FromParamsList;
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
        if(FromParamsList!=null) FromParamsList.accept(visitor);
        if(FromParamsVal!=null) FromParamsVal.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FromParamsList!=null) FromParamsList.traverseTopDown(visitor);
        if(FromParamsVal!=null) FromParamsVal.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FromParamsList!=null) FromParamsList.traverseBottomUp(visitor);
        if(FromParamsVal!=null) FromParamsVal.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultiFormParams(\n");

        if(FromParamsList!=null)
            buffer.append(FromParamsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FromParamsVal!=null)
            buffer.append(FromParamsVal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultiFormParams]");
        return buffer.toString();
    }
}

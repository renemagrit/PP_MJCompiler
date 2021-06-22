// generated with ast extension for cup
// version 0.8
// 22/5/2021 17:43:35


package rs.ac.bg.etf.pp1.ast;

public class FromParameters extends FromParams {

    private FromParamsList FromParamsList;

    public FromParameters (FromParamsList FromParamsList) {
        this.FromParamsList=FromParamsList;
        if(FromParamsList!=null) FromParamsList.setParent(this);
    }

    public FromParamsList getFromParamsList() {
        return FromParamsList;
    }

    public void setFromParamsList(FromParamsList FromParamsList) {
        this.FromParamsList=FromParamsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FromParamsList!=null) FromParamsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FromParamsList!=null) FromParamsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FromParamsList!=null) FromParamsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FromParameters(\n");

        if(FromParamsList!=null)
            buffer.append(FromParamsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FromParameters]");
        return buffer.toString();
    }
}

// generated with ast extension for cup
// version 0.8
// 26/5/2021 20:42:7


package rs.ac.bg.etf.pp1.ast;

public class FromParamsValue extends FromParamsVal {

    private Type Type;
    private VarVal VarVal;

    public FromParamsValue (Type Type, VarVal VarVal) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.VarVal=VarVal;
        if(VarVal!=null) VarVal.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public VarVal getVarVal() {
        return VarVal;
    }

    public void setVarVal(VarVal VarVal) {
        this.VarVal=VarVal;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(VarVal!=null) VarVal.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VarVal!=null) VarVal.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VarVal!=null) VarVal.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FromParamsValue(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarVal!=null)
            buffer.append(VarVal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FromParamsValue]");
        return buffer.toString();
    }
}

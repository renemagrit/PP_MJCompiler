// generated with ast extension for cup
// version 0.8
// 29/5/2021 14:44:46


package rs.ac.bg.etf.pp1.ast;

public class Designator implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private DesName DesName;
    private DesigantorList DesigantorList;

    public Designator (DesName DesName, DesigantorList DesigantorList) {
        this.DesName=DesName;
        if(DesName!=null) DesName.setParent(this);
        this.DesigantorList=DesigantorList;
        if(DesigantorList!=null) DesigantorList.setParent(this);
    }

    public DesName getDesName() {
        return DesName;
    }

    public void setDesName(DesName DesName) {
        this.DesName=DesName;
    }

    public DesigantorList getDesigantorList() {
        return DesigantorList;
    }

    public void setDesigantorList(DesigantorList DesigantorList) {
        this.DesigantorList=DesigantorList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesName!=null) DesName.accept(visitor);
        if(DesigantorList!=null) DesigantorList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesName!=null) DesName.traverseTopDown(visitor);
        if(DesigantorList!=null) DesigantorList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesName!=null) DesName.traverseBottomUp(visitor);
        if(DesigantorList!=null) DesigantorList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator(\n");

        if(DesName!=null)
            buffer.append(DesName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesigantorList!=null)
            buffer.append(DesigantorList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator]");
        return buffer.toString();
    }
}

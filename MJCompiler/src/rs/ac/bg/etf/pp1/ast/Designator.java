// generated with ast extension for cup
// version 0.8
// 22/5/2021 19:58:41


package rs.ac.bg.etf.pp1.ast;

public class Designator implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private DesigantorList DesigantorList;

    public Designator (String I1, DesigantorList DesigantorList) {
        this.I1=I1;
        this.DesigantorList=DesigantorList;
        if(DesigantorList!=null) DesigantorList.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
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
        if(DesigantorList!=null) DesigantorList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesigantorList!=null) DesigantorList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesigantorList!=null) DesigantorList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator(\n");

        buffer.append(" "+tab+I1);
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

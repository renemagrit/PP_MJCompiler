// generated with ast extension for cup
// version 0.8
// 28/5/2021 18:6:14


package rs.ac.bg.etf.pp1.ast;

public class Designator implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private String desigantorName;
    private DesigantorList DesigantorList;

    public Designator (String desigantorName, DesigantorList DesigantorList) {
        this.desigantorName=desigantorName;
        this.DesigantorList=DesigantorList;
        if(DesigantorList!=null) DesigantorList.setParent(this);
    }

    public String getDesigantorName() {
        return desigantorName;
    }

    public void setDesigantorName(String desigantorName) {
        this.desigantorName=desigantorName;
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

        buffer.append(" "+tab+desigantorName);
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

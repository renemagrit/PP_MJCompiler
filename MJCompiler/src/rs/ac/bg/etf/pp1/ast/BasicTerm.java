// generated with ast extension for cup
// version 0.8
// 22/5/2021 19:58:42


package rs.ac.bg.etf.pp1.ast;

public class BasicTerm extends Term {

    private Factor Factor;
    private TermRepeat TermRepeat;

    public BasicTerm (Factor Factor, TermRepeat TermRepeat) {
        this.Factor=Factor;
        if(Factor!=null) Factor.setParent(this);
        this.TermRepeat=TermRepeat;
        if(TermRepeat!=null) TermRepeat.setParent(this);
    }

    public Factor getFactor() {
        return Factor;
    }

    public void setFactor(Factor Factor) {
        this.Factor=Factor;
    }

    public TermRepeat getTermRepeat() {
        return TermRepeat;
    }

    public void setTermRepeat(TermRepeat TermRepeat) {
        this.TermRepeat=TermRepeat;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Factor!=null) Factor.accept(visitor);
        if(TermRepeat!=null) TermRepeat.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Factor!=null) Factor.traverseTopDown(visitor);
        if(TermRepeat!=null) TermRepeat.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Factor!=null) Factor.traverseBottomUp(visitor);
        if(TermRepeat!=null) TermRepeat.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BasicTerm(\n");

        if(Factor!=null)
            buffer.append(Factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TermRepeat!=null)
            buffer.append(TermRepeat.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BasicTerm]");
        return buffer.toString();
    }
}

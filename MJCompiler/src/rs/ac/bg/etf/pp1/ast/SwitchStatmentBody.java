// generated with ast extension for cup
// version 0.8
// 28/5/2021 18:6:14


package rs.ac.bg.etf.pp1.ast;

public class SwitchStatmentBody extends SwitchStmtBody {

    private SwitchStmtList SwitchStmtList;
    private DefaulStmt DefaulStmt;

    public SwitchStatmentBody (SwitchStmtList SwitchStmtList, DefaulStmt DefaulStmt) {
        this.SwitchStmtList=SwitchStmtList;
        if(SwitchStmtList!=null) SwitchStmtList.setParent(this);
        this.DefaulStmt=DefaulStmt;
        if(DefaulStmt!=null) DefaulStmt.setParent(this);
    }

    public SwitchStmtList getSwitchStmtList() {
        return SwitchStmtList;
    }

    public void setSwitchStmtList(SwitchStmtList SwitchStmtList) {
        this.SwitchStmtList=SwitchStmtList;
    }

    public DefaulStmt getDefaulStmt() {
        return DefaulStmt;
    }

    public void setDefaulStmt(DefaulStmt DefaulStmt) {
        this.DefaulStmt=DefaulStmt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SwitchStmtList!=null) SwitchStmtList.accept(visitor);
        if(DefaulStmt!=null) DefaulStmt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SwitchStmtList!=null) SwitchStmtList.traverseTopDown(visitor);
        if(DefaulStmt!=null) DefaulStmt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SwitchStmtList!=null) SwitchStmtList.traverseBottomUp(visitor);
        if(DefaulStmt!=null) DefaulStmt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SwitchStatmentBody(\n");

        if(SwitchStmtList!=null)
            buffer.append(SwitchStmtList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DefaulStmt!=null)
            buffer.append(DefaulStmt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SwitchStatmentBody]");
        return buffer.toString();
    }
}

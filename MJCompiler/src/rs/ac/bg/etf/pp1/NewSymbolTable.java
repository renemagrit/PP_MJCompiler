package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class NewSymbolTable extends Tab {
	
	public static final Struct booleanType = new Struct(Struct.Bool);
	
	public static void init() {
		Tab.init();
		currentScope().addToLocals(new Obj(Obj.Type, "boolean", booleanType));
	}
}

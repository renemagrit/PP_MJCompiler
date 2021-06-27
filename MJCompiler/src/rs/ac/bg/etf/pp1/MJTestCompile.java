package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import java_cup.runtime.Symbol;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.test.Compiler;
import rs.ac.bg.etf.pp1.test.CompilerError;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;

public class MJTestCompile implements Compiler {

	private ArrayList<CompilerError> lisOfErrors = new ArrayList<CompilerError>();
	
	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	public static void main(String[] args) throws Exception {
				
		MJTestCompile.getInstance().compile("test/program.mj", "test/program.obj");
	}
	
	public void addError(CompilerError error) {
		lisOfErrors.add(error);
	}
	private void printErrList() {
		
		
	}
	
	private static MJTestCompile instance = null;
	
	public static MJTestCompile getInstance() {
		if(instance == null)
			instance = new MJTestCompile();
		return instance;
	}
	

	@Override
	public List<CompilerError> compile(String sourceFilePath, String outputFilePath) {
		Logger log = Logger.getLogger(MJTestCompile.class);
		
		Reader br = null;
		try {
			File sourceCode = new File(sourceFilePath);
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());
			
			br = new BufferedReader(new FileReader(sourceCode));
			Yylex lexer = new Yylex(br);
			
			MJParser p = new MJParser(lexer);
	        Symbol s = p.parse();  //pocetak parsiranja
	        
	        Program prog = (Program)(s.value); 
	        NewSymbolTable.init();
			// ispis sintaksnog stabla
			log.info(prog.toString(""));
			log.info("===================================");

			// ispis prepoznatih programskih konstrukcija
			SemanticAnalyzer v = new SemanticAnalyzer();
			prog.traverseBottomUp(v); 
			log.info("===================================");
			NewSymbolTable.dump();		
			
			lisOfErrors.forEach((err)-> log.info(err.toString()));
			
			if(!v.passed()) {
				File objFile = new File(outputFilePath);
				
				if(objFile.exists())
					objFile.delete();
				
				CodeGenerator codeGen = new CodeGenerator();
				prog.traverseBottomUp(codeGen);
				Code.dataSize = v.getNumVars();
				Code.mainPc = codeGen.getMainPc();
				
			
				Code.write(new FileOutputStream(objFile));
				
				
				log.info("Parsiranje uspesno zavrseno!");
				 
			}else {
				log.error("Parsiranje NIJE uspelo!");
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		finally {
			if (br != null) try { br.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
		}
		
		return null;
	}
	
	
}

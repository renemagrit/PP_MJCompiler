
package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{

	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}
	// Boolean to Integer
	private Symbol new_symbolBoolean(int type, String value) {
		if(Boolean.parseBoolean(value))
			return new Symbol(type, yyline+1, yycolumn, 1);
		else
			return new Symbol(type, yyline+1, yycolumn, 0);
	}

%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

" " 			{ }
"\b" 			{ }
"\t" 			{ }
"\r\n" 			{ }
"\f" 			{ }

/* Keywords */

"program"   	{ return new_symbol(sym.PROG, yytext()); }
"print" 		{ return new_symbol(sym.PRINT, yytext()); }
"return" 		{ return new_symbol(sym.RETURN, yytext()); }
"void" 			{ return new_symbol(sym.VOID, yytext()); }
"read" 			{ return new_symbol(sym.READ, yytext()); }
"new" 			{ return new_symbol(sym.NEW, yytext()); }
"if" 			{ return new_symbol(sym.IF, yytext()); }
"else" 			{ return new_symbol(sym.ELSE, yytext()); }
"do" 			{ return new_symbol(sym.DO, yytext()); }
"while"			{ return new_symbol(sym.WHILE, yytext()); }
"break"			{ return new_symbol(sym.BREAK, yytext()); }
"continue"		{ return new_symbol(sym.CONTINUE, yytext()); }
"switch"		{ return new_symbol(sym.SWITCH, yytext()); }
"case" 			{ return new_symbol(sym.CASE, yytext()); }
"class"			{ return new_symbol(sym.CLASS, yytext()); }
"extends"		{ return new_symbol(sym.EXTENDS, yytext()); }
"yield"			{ return new_symbol(sym.YIELD, yytext()); }
"default"		{ return new_symbol(sym.DEFAULT, yytext()); }
"const" 		{ return new_symbol(sym.CONST, yytext()); }


/* Operators */

"++"			{ return new_symbol(sym.INC, yytext()); }
"--"			{ return new_symbol(sym.DEC, yytext()); }
"*" 			{ return new_symbol(sym.MUL, yytext()); }
"/" 			{ return new_symbol(sym.DIV, yytext()); }
"%" 			{ return new_symbol(sym.MOD, yytext()); }
"&&" 			{ return new_symbol(sym.AND, yytext()); }
"||" 			{ return new_symbol(sym.OR, yytext()); }
"=="			{ return new_symbol(sym.ISEQUAL, yytext()); }
"!="			{ return new_symbol(sym.NOTEQUAL, yytext()); }
"<"				{ return new_symbol(sym.LESS, yytext()); }
">"				{ return new_symbol(sym.GREATER, yytext()); }
"<="			{ return new_symbol(sym.LESSEQ, yytext()); }
">="			{ return new_symbol(sym.GREATEREQ, yytext()); }
"=" 			{ return new_symbol(sym.EQUAL, yytext()); }
"+" 			{ return new_symbol(sym.PLUS, yytext()); }
"-"				{ return new_symbol(sym.MINUS, yytext()); }

"true"|"false"	{ return new_symbolBoolean(sym.BOOLCONST, yytext()); }
"'"."'"			{ return new_symbol(sym.CHARCONST, yytext().charAt(1)); }

/* Others */

";" 			{ return new_symbol(sym.SEMI, yytext()); }
":" 			{ return new_symbol(sym.COLON, yytext()); }
"," 			{ return new_symbol(sym.COMMA, yytext()); }
"(" 			{ return new_symbol(sym.LPAREN, yytext()); }
")" 			{ return new_symbol(sym.RPAREN, yytext()); }
"{" 			{ return new_symbol(sym.LBRACE, yytext()); }
"}"				{ return new_symbol(sym.RBRACE, yytext()); }
"["				{ return new_symbol(sym.LBRACKET, yytext()); }
"]"				{ return new_symbol(sym.RBRACKET, yytext()); }
"."				{ return new_symbol(sym.DOT, yytext()); }


"//" {yybegin(COMMENT);}
<COMMENT> . {yybegin(COMMENT);}
<COMMENT> "\r\n" { yybegin(YYINITIAL); }

[0-9]+  { return new_symbol(sym.NUMBER, new Integer (yytext())); }
([a-z]|[A-Z])[a-z|A-Z|0-9|_]* 	{return new_symbol (sym.IDENT, yytext()); }

. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1)); }











package org.example.snackScript;

import snackScript.parser.SnackScriptLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;

public class Scanner {
    private final SnackScript compiler;

    public Scanner(SnackScript compiler) {
        this.compiler = compiler;
    }

    public Lexer getTokens(CharStream chars) {
        var lex = new SnackScriptLexer(chars);
        lex.removeErrorListeners();
        //lex.addErrorListener(compiler.errorListener());
        return lex;
    }
}

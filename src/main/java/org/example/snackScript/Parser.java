package org.example.snackScript;

import snackScript.parser.SnackScriptParser;
import snackScript.parser.SnackScriptParser.StartContext;
import lombok.Getter;

import org.antlr.v4.runtime.*;

public class Parser {
    private final SnackScript compiler;

    @Getter
    private SnackScriptParser snackScriptParser;

    public Parser(SnackScript compiler) {
        this.compiler = compiler;
    }

    public StartContext getSyntaxTree(Lexer tokens) {
        CommonTokenStream tokenStream = new CommonTokenStream(tokens);
        snackScriptParser = new SnackScriptParser(tokenStream);
        snackScriptParser.removeErrorListeners();
        //snackScriptParser.addErrorListener(compiler.errorListener());

        return snackScriptParser.start();
    }

}

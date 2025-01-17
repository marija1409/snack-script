package org.example;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.example.snackScript.Parser;
import org.example.snackScript.Scanner;
import org.example.snackScript.SnackScript;
import org.example.snackScript.Typecheck;
import org.example.snackScript.ast.ASTPrettyPrinter;
import org.example.snackScript.ast.CSTtoASTConverter;
import org.example.snackScript.ast.StatementList;
import org.example.snackScript.compiler.Compiler;
import org.example.snackScript.vm.VM;
import org.example.utils.PrettyPrint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static SnackScript snackScript = new SnackScript();
    static boolean hadError = false;
    static boolean hadRuntimeError = false;
    private static final Compiler compiler = new Compiler(snackScript);
    private static final VM vm = new VM(snackScript);

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose input mode:\n1 - Enter file path\n2 - Type code directly");
        String choice = reader.readLine();

        if (choice.equals("1")) {
            System.out.print("Enter the path to the .snack file: ");
            String filePath = reader.readLine();
            runFile(filePath);
        } else if (choice.equals("2")) {
            runPrompt();
        } else {
            System.out.println("Invalid choice. Exiting.");
        }
    }

    private static void runFile(String path) throws IOException {
        run(CharStreams.fromFileName(path));
        if (snackScript.hadError()) System.exit(65);
        if (snackScript.hadRuntimeError()) System.exit(70);
    }

    private static void runPrompt() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        while (true) {
            System.out.print("> ");
            String line = reader.readLine();

            if (line == null || line.equalsIgnoreCase("exit")) {
                System.out.println();
                break;
            }

            snackScript.setHadError(false);
            snackScript.setHadRuntimeError(false);
            run(CharStreams.fromString(line));
        }
    }

    private static void run(CharStream source) {
        Scanner scanner = new Scanner(snackScript);
        var tokens = scanner.getTokens(source);

        if (snackScript.hadError()) return;

        Parser parser = new Parser(snackScript);
        var tree = parser.getSyntaxTree(tokens);

        System.out.println("Syntax Tree: " +
                PrettyPrint.prettyPrintTree(tree, parser.getSnackScriptParser().getRuleNames()));

        if (snackScript.hadError()) return;
        System.out.println("AST:");
        var pp = new ASTPrettyPrinter(System.out);
        var program = (StatementList) tree.accept(new CSTtoASTConverter(snackScript));
        program.prettyPrint(pp);

        if (snackScript.hadError()) return;

        //Added this to start type checking:
        new Typecheck(snackScript).typecheck(program);
        System.out.println("tAST:");
        program.prettyPrint(pp);
        if (snackScript.hadError()) return;
        System.out.println("Success!");

        //Medjukod:
        var bytecode = compiler.compileInput(program);
        snackScript.dumpNewAssembly(System.out, bytecode);
        /* The compiler cannot emit errors.  */
        assert !snackScript.hadError();

        vm.run(bytecode);
    }
}

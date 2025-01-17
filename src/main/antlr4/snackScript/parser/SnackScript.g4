grammar SnackScript;

start: statement* EOF;

statement
    : declaration ';'
    | assign ';'
    | printStatement ';'
    | expr ';'
    | inputStatement ';'
    | ifStatement
    | whileStatement
    | forStatement
    | functionStatement
    | returnStatement ';'
    ;

block
    : '{' statement* '}'
    ;

declaration
    : type IDENTIFIER EQUAL expr // deklarisanje promenjljive i inicijalizacija
    | type IDENTIFIER // deklarisanje promenjljive bez arg
    | type IDENTIFIER EQUAL arrayLiteral // deklarisanje niza
    ;

assign
    : arrayAccess EQUAL expr
    ;

printStatement
    : PRINT '(' expr (COMMA expr)* ')' // spit('hello')
    ;

inputStatement
    : INPUT '(' STRING ')' // eat('unesi')
    ;

returnStatement
    : RETURN expr
    ;


ifStatement
    : IF '(' logicalExpr ')' '{' ifBlock+= statement* '}' (ELSE '{' elseBlock+= statement* '}')? // check (condition) { ... } [ohwell { ... }]
    ;


whileStatement
    :WHILE '(' logicalExpr ')' block // "until (condition) { ... }"
    ;

forStatement
    : FOR '(' declaration? ';' comparisonExpr? ';' incrementExpr? ')' block // each (init; condition; increment) { ... }
    ;

functionStatement
    : tip= type FUN IDENTIFIER '(' (declaration(',' declaration)*)? ')' (block | ';') //returnType fun name(param1, param2) { ... }
    ;

incrementExpr
    : IDENTIFIER (PLUS_PLUS | MINUS_MINUS)
    ;


expr
    : logicalExpr
    ;

logicalExpr
    : left= comparisonExpr (logOp+=(AND | OR) right+=comparisonExpr)*
    ;

comparisonExpr
    : left= additionExpr (operators+=(LESS | GREATER | LESS_EQUAL | GREATER_EQUAL | EQUAL_EQUAL | NOT_EQUAL) right+=additionExpr)*
    ;

additionExpr
    : initial=multiplicationExpr (op+=(PLUS | MINUS) rest+=multiplicationExpr)*;

multiplicationExpr
    : initial=exponentExpr (op+=(STAR | SLASH) rest+=exponentExpr)* ;

exponentExpr
    : lhs=arrayAccess (CARET rhs=exponentExpr)? ;


arrayAccess
    :name = atom ('[' expr ']')*
    ;

atom
    : NUMBER #NumberConstant
    | IDENTIFIER #VariableReference
    | '(' expr ')' #GroupingOperator
    | arrayLiteral #ArrayConstructor
    | STRING #StringLiteral
    | TRUE #TrueLiteral
    | FALSE #FalseLiteral
    | functionCall #FunCall
    ;

functionCall
    : 'eat' IDENTIFIER '(' (expr (COMMA expr)*)? ')'
    ;

arrayLiteral
    : ARRAY_OPEN (expr (COMMA expr)*)? ARRAY_CLOSE
    ;


type
    : NUM #IntType
    | BOOL #BoolType
    | LINE #StringType
    | ARRAY #array
    | ARRAY type #ArrayType
    ;

// Tokens
STRING: '"' (ESC | ~["\\])* '"';
fragment ESC: '\\' ["\\];
TRUE: 'true';
FALSE: 'false';



NUM: 'num';
BOOL: 'bool';
LINE: 'line';
ARRAY: 'bunch';

PRINT: 'spit';
INPUT: 'input';
IF: 'check';
ELSE: 'ohwell';
WHILE: 'until';
FOR: 'each';
FUN: 'fun';
RETURN: 'vomit';

AND: 'and';
OR: 'or';
LEFT_PAREN: '(';
RIGHT_PAREN: ')';
CARET: '^';
STAR: '*';
SLASH: '/';
PLUS: '+';
MINUS: '-';
ARRAY_OPEN: '[';
ARRAY_CLOSE: ']';
COMMA: ',';
EQUAL: '=';
LESS: '<';
GREATER: '>';
LESS_EQUAL: '<=';
GREATER_EQUAL: '>=';
EQUAL_EQUAL: '==';
NOT_EQUAL: '!=';
PLUS_PLUS: '++';
MINUS_MINUS: '--';


// Fragment Rules and Identifiers
fragment DIGIT: [0-9];
fragment NZERO: [1-9];

NUMBER: ('-')? (NZERO DIGIT* | '0') ('.' DIGIT+)?; // Allows integers and decimals 0
IDENTIFIER: [a-zA-Z_] [a-zA-Z_0-9]*; // Identifiers for vectors (e.g., a, b, m)

// Skipped Tokens
SPACES: [ \u000B\t\r\n\p{White_Space}] -> skip; // Skips whitespace
COMMENT: '/*' .*? '*/' -> skip; // Skips block comments
LINE_COMMENT: '//' ~[\r\n]* -> skip; // Skips line comments

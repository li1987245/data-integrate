grammar Calc;
calc: stmt*;
stmt:   expr NEWLINE             # printExpr
    |   ID '=' expr NEWLINE      # assign
    |   NEWLINE                  # blank
    ;

expr:   expr op=('*'|'/') expr   # mulDiv
    |   expr op=('+'|'-') expr   # addSub
    |   NUMBER                   # literal
    |   ID                       # id
    |   '(' expr ')'             # paren
    ;
MUL : '*';
DIV : '/';
ADD : '+';
SUB : '-';
LP   : '(';
RP   : ')';
ID  : Letter LetterOrDigit*;
NUMBER  : DIGIT+
        | DIGIT+ '.' DIGIT*
        | '.' DIGIT+
        ;
fragment Letter: [a-zA-Z_];
fragment Digit: [0-9];
fragment LetterOrDigit: Letter | Digit;
fragment DIGIT : '0'..'9';
NEWLINE: '\r'? '\n';
//------ Numbers
INT   : DIGIT+ ;
FLOAT : DIGIT+ '.' DIGIT*
      | '.' DIGIT+
      ;
//------ Strings
STRING : '"' (ESC | .)*? '"' ;
fragment ESC : '\\' [btnr"\\] ;  // \b, \t, \n, ...
//------ Comments
LINE_COMMENT  : '//' .*? '\n' -> skip;
BLOCK_COMMENT : '/*' .*? '*/' -> skip;
//------ Whitespace
WS : [ \t\n\r]+ -> skip;










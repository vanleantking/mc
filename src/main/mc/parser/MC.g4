/**
 * Student name:
 * Student ID:
 */
grammar MC;

@lexer::header{
	package mc.parser;
}

@lexer::members{
@Override
public Token emit() {
    switch (getType()) {
    case UNCLOSE_STRING:       
        Token result = super.emit();
        // you'll need to define this method
        throw new UncloseString(result.getText());
        
    case ILLEGAL_ESCAPE:
    	result = super.emit();
    	throw new IllegalEscape(result.getText());

    case ERROR_CHAR:
    	result = super.emit();
    	throw new ErrorToken(result.getText());	

    default:
        return super.emit();
    }
}
}

@parser::header{
	package mc.parser;
}

options{
	language=Java;
}

program: one_decl+ EOF;
//many_decl: one_decl many_decl | one_decl;
one_decl: var_decl | func_decl;

//variable declare
var_decl: primitivetype variable (COMMA variable)* SEMI;
variable: IDENTIFIERS (LSB INTLIT RSB)?;

//type
type: primitivetype | VOID | array_type | array_pointer_type;

//function declare
func_decl: function_type IDENTIFIERS LB list_parameter_decl? RB block_statement;
function_type: array_pointer_type | primitivetype | VOID;
list_parameter_decl: parameter_decl (COMMA parameter_decl)*;
parameter_decl: primitivetype IDENTIFIERS (LSB RSB)?;


array_type: primitivetype LSB INTLIT RSB;
array_pointer_type: input_param_pointer | output_param_pointer;
input_param_pointer: primitivetype IDENTIFIERS LSB RSB;
output_param_pointer: primitivetype LSB RSB;

//expression
expr: term1 '=' expr | term1;
term1: term1 '||' term2
        | term2;
term2: term2 '&&' term3
        | term3;
term3: term4 '==' term4
        | term4 '!=' term4
        | term4;
term4: term5 '<' term5
        | term5 '<=' term5
        | term5 '>' term5
        | term5 '>=' term5
        | term5;
term5: term5 '+' term6
        | term5 '-' term6
        | term6;
term6: term6 '/' term7
    | term6 '*' term7
    | term6 '%' term7
    | term7;
term7: ('-' | '!') term7| term8;
term8: term9 '[' expr ']' | term9;
term9: LB expr RB | IDENTIFIERS | BOOLEAN_LITERAL | INTLIT | FLOAT_LITERAL | STRINGLIT | function_call;
function_call: IDENTIFIERS LB expr_list? RB;
expr_list: expr (COMMA expr)*;


//index expression
//index_expr: expr '[' expr ']';

//statement and control flow
statement: if_statement | for_statement | do_statement | break_statement | continue_statement | return_statement | block_statement | expr_statement;
if_statement: IF LB expr RB statement (ELSE statement)?;
do_statement: DO statement+ 'while' expr SEMI;
for_statement: FOR LB expr SEMI expr SEMI expr RB statement;
break_statement: BREAK SEMI;
continue_statement: CONTINUE SEMI;
return_statement: RETURN expr? SEMI;
expr_statement: expr SEMI;
block_statement: LP (var_decl | statement)* RP;

////Comment
BLOCK_COMMENT: '/*' .*? '*/' -> skip;
LINE_COMMENT: '//' ~[\r\n]*? '\r'? ('\n'|EOF) -> skip;


//Literal
//int literal
INTLIT: DIGIT+;
//float literal
//FLOAT_LITERAL: IntPart (DecPart ExpPart | DecPart | ExpPart);
FLOAT_LITERAL: Decimal Exponent? | DIGIT+ Exponent;
//boolean literal
BOOLEAN_LITERAL: 'true' | 'false';
//string literal
//STRINGLIT: '\"' STRINGELM* '\"';
//STRINGLIT:  '\"' StringElement* '\"';
STRINGLIT: '"' ( '\\' [btnfr"'\\] | ~[\r\n\\"] )* '"' {setText(getText().substring(1, getText().length() - 1));};
primitivetype: INT | FLOAT | BOOLEAN | STRING;


//keyword
BOOLEAN: 'boolean';
BREAK: 'break';
CONTINUE: 'continue';
ELSE: 'else';
FOR: 'for';
FLOAT: 'float';
IF: 'if';
INT: 'int';
RETURN: 'return';
VOID: 'void';
DO: 'do';
WHILE: 'while';
TRUE: 'true';
FALSE: 'false';
STRING: 'string';

//operators
ADD: '+'; //addition or unary plus
SUB: '-'; //subtraction or minus
MUL: '*'; //multiplication
FDIV: '/'; //division
NOT: '!'; //logical not
MOD: '%'; //modulus
OR: '||'; //logical or
AND: '&&'; //logical and
NEQU: '!='; //not equal
EQU: '=='; //equal
LT: '<'; //less than
GT: '>'; //greater than
LE: '<='; //less than or equal
GE: '>='; //greater than or equal
ASSIGN: '=';


//Separator
LB: '(' ;
RB: ')' ;
LP: '{';
RP: '}';
LSB: '[';
RSB: ']';
SEMI: ';' ;
COLON: ':';
COMMA: ',';
LF: '\\n';
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

//identifiers
IDENTIFIERS: [a-zA-Z_][a-zA-Z0-9_]*;
//fragment StringElement: '\u0020'| '\u0021'|'\u0023' .. '\u005B' | '\u005D'..'\u007E' |  ESCAPECHARS;
//fragment StringElement: ~[\r\n\\"] | ESCAPECHARS;
//fragment ESCAPECHARS: '\\' [btnfr"'\\];
fragment LOWERCASE: [a-z];
fragment UPPERCASE: [A-Z];
fragment DIGIT: [0-9];
fragment UNDERSCORE: '_';
//fragment IntPart:DIGIT+;
//fragment DecPart:'.'DIGIT*;
//fragment ExpPart:('E'|'e') ('+'|'-')? DIGIT+;
fragment Decimal: DIGIT+ '.'DIGIT* | DIGIT* '.'DIGIT+;
fragment Exponent: [Ee] '-'? DIGIT+;
ERROR_CHAR: .;
UNCLOSE_STRING: '"' ( '\\' [btnfr"'\\] | ~[\r\n\\"] )*;
ILLEGAL_ESCAPE: .;
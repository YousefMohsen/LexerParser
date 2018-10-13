grammar simpleCalc;
 
start   : as+=assign*   sts+=stmt* e=expr+ EOF ;

assign  : x=ID '=' e=expr  ;

stmt: 'if' '('c=cond')' e1=expr 'else'  e2=expr  #IfStatment
    | 'while' '('c=cond')' e=expr #WhileStatment
    ;

cond: e1=expr  op='==' e2=expr #Comparison
    | e1=expr op='!=' e2=expr #Comparison
    | e1=expr op='<' e2=expr #Comparison
    | e1=expr op='>' e2=expr #Comparison
    | c1=cond op='&&' c2=cond #LogicalOp
    | c1=cond op='||' c2=cond #LogicalOp
    ;

expr: e1=expr op=OP1 e2=expr # Calculate
    | e1=expr op=OP2 e2=expr # Calculate
	| n=NUM  	        # Constant
	| x=ID            # Variable
	| '(' e=expr ')'  # Parenthesis
	| x=ID '=' e=expr #AssignVar
	| e1=expr  op='==' e2=expr #Equals
	;

OP1 : ('*'|'/') ;
OP2 : ('+'|'-') ;
NUM 	: ('0'..'9')+ ;
ID	: ('A'..'Z'|'a'..'z')+ ;
WHITESPACE : [ \n\t\r]+ -> skip;
COMMENT :    '//' ~('\n')* -> skip;


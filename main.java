import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {

        // we expect exactly one argument: the name of the input file
        if (args.length != 1) {
            System.err.println("\n");
            System.err.println("Simple calculator\n");
            System.err.println("=================\n\n");
            System.err.println("Please give as input argument a filename\n");
            System.exit(-1);
        }
        String filename = args[0];

        // open the input file
        CharStream input = CharStreams.fromFileName(filename);
        //new ANTLRFileStream (filename); // depricated

        // create a lexer/scanner
        simpleCalcLexer lex = new simpleCalcLexer(input);

        // get the stream of tokens from the scanner
        CommonTokenStream tokens = new CommonTokenStream(lex);

        // create a parser
        simpleCalcParser parser = new simpleCalcParser(tokens);

        // and parse anything from the grammar for "start"
        ParseTree parseTree = parser.start();

        // Construct an interpreter and run it on the parse tree
        Interpreter interpreter = new Interpreter();
        Double result = interpreter.visit(parseTree);
        System.out.println("Enviorment: \n " + interpreter.toString());

        System.out.println("\nThe result is: " + result);

    }
}

// We write an interpreter that implements interface
// "simpleCalcVisitor<T>" that is automatically generated by ANTLR
// This is parameterized over a return type "<T>" which is in our case
// simply a Double.

class Interpreter extends AbstractParseTreeVisitor<Double> implements simpleCalcVisitor<Double> {

    static Environment env = new Environment();

    public Double visitStart(simpleCalcParser.StartContext ctx) {
        for (simpleCalcParser.AssignContext a : ctx.as) {
            visit(a);
        }
        for (simpleCalcParser.StmtContext a : ctx.sts) {
            visit(a);
        }


        return visit(ctx.e);
    }


    public Double visitAssign(simpleCalcParser.AssignContext ctx) {
        Double d = visit(ctx.e);
        env.setVariable(ctx.x.getText(), d);
        return d;
    }
    public Double visitAssignVar(simpleCalcParser.AssignVarContext ctx) {
        Double d = visit(ctx.e);
        env.setVariable(ctx.x.getText(), d);
        return d;
    }


    public Double visitParenthesis(simpleCalcParser.ParenthesisContext ctx) {
        return visit(ctx.e);
    }


    public Double visitVariable(simpleCalcParser.VariableContext ctx) {
        return env.getVariable(ctx.x.getText());
    }


    public Double visitCalculate(simpleCalcParser.CalculateContext ctx) {

        switch (ctx.op.getText()) {
            case "+":
                return visit(ctx.e1) + visit(ctx.e2);
            case "*":
                return visit(ctx.e1) * visit(ctx.e2);
            case "-":
                return visit(ctx.e1) - visit(ctx.e2);
            default:
                return visit(ctx.e1) / visit(ctx.e2);
        }

    }


   /* public Double visitVar(simpleCalcParser.VarContext ctx) {

        //return Double.parseDouble(ctx.getText()); // new Double(ctx.NUM()); // Integer.parseInt(string);

        return 1.0;
    }*/

    public Double visitConstant(simpleCalcParser.ConstantContext ctx) {
        return Double.parseDouble(ctx.n.getText()); // new Double(ctx.NUM()); // Integer.parseInt(string);

    }

    public Double visitComparison(simpleCalcParser.ComparisonContext ctx) {

        try {
            int e1 = Integer.parseInt(ctx.e1.getText());
            int e2 = Integer.parseInt(ctx.e2.getText());
            /*
            Double e1 = visit(ctx.e1);
            Double e2 = visit(ctx.e2);*/
            switch (ctx.op.getText()) {
                case "==":
                    return e1 == e2 ? 1.0 : 0.0;
                case "!=":
                    return e1 != e2 ? 1.0 : 0.0;
                case "<":
                    return e1 < e2 ? 1.0 : 0.0;
                case ">":
                    return e1 > e2 ? 1.0 : 0.0;
                default:
                    return 0.0;
            }

        } catch (NumberFormatException ex) {
            return 0.0;
        }

    }





    public Double visitLogOp(simpleCalcParser.LogOpContext ctx) {
        try {
            Double c1 = visit(ctx.c1);
            Double c2 = visit(ctx.c2);
            switch (ctx.op.getText()) {
                case "&&":
                    return c1 ==1.0 &&  c2 == 1.0 ? 1.0 : 0.0;
                case "||":
                    return c1==1.0 || c2==1.0 ? 1.0 :  0.0;
                default:
                    return 0.0;
            }

        } catch (NumberFormatException ex) {
            return 2000.0;

        }

    }

    /* public Double visitStmt(simpleCalcParser.StmtContext ctx) {
         if( visit(ctx.c)==1.0){
             return visit(ctx.e1);
         }
         return visit(ctx.e2);

     }*/
    public Double visitIfStatment(simpleCalcParser.IfStatmentContext ctx) {
        if( visit(ctx.c)==1.0){
            return visit(ctx.e1);
        }
        return visit(ctx.e2);
    }


    public Double visitWhileStatment(simpleCalcParser.WhileStatmentContext ctx) {
        while ( visit(ctx.c)==1.0){
            visit(ctx.e);
        }
        return 0.0;
    }

    public Double visitEquals(simpleCalcParser.EqualsContext ctx) {

        try {
            int e1 = Integer.parseInt(ctx.e1.getText());
            int e2 = Integer.parseInt(ctx.e2.getText());

            return e1 == e2 ? 1.0 : 0.0;

        }

        catch (NumberFormatException ex) {
            return 0.0;
        }

    }


/*
    public Double visitStmts(simpleCalcParser.StmtsContext ctx) {
        return 1.0;
    }*/
/*
    public Double visitProg(simpleCalcParser.ProgContext ctx) {
        return 1.0;
    }*/

    /*public Double visitStatement(simpleCalcParser.StatementContext ctx) {
        return 1.0;
    }
*/
    public String toString(){
        return  " "+env.toString();

    }

}

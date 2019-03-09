package io.github.calc.listener;

import io.github.calc.CalcBaseListener;
import io.github.calc.CalcParser;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.HashMap;
import java.util.Map;

public class Evaluator extends CalcBaseListener {
    public Map<String, Double> vars = new HashMap<>();
    public ParseTreeProperty<Double> values = new ParseTreeProperty<>();

    // stmt : ID '=' expr NEWLINE ;
    @Override
    public void exitAssign(CalcParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        Double val = values.get(ctx.expr());
        vars.put(id, val);
    }

    // stmt : expr NEWLINE ;
    @Override
    public void exitPrintExpr(CalcParser.PrintExprContext ctx) {
        System.out.println(values.get(ctx.expr()));
    }

    // expr : NUMBER ;
    @Override
    public void exitLiteral(CalcParser.LiteralContext ctx) {
        values.put(ctx, Double.valueOf(ctx.NUMBER().getText()));
    }

    // expr : ID ;
    @Override
    public void exitId(CalcParser.IdContext ctx) {
        values.put(ctx, vars.containsKey(ctx.ID().getText()) ? vars.get(ctx.ID().getText()) : .0);
    }

    // expr : expr op=('*'|'/') expr ;
    @Override
    public void exitMulDiv(CalcParser.MulDivContext ctx) {
        double lhs = values.get(ctx.expr(0));
        double rhs = values.get(ctx.expr(1));
        values.put(ctx, ctx.op.getType() == CalcParser.MUL ? lhs * rhs : lhs / rhs);
    }

    // expr : expr op=('+'|'-') expr ;
    @Override
    public void exitAddSub(CalcParser.AddSubContext ctx) {
        double lhs = values.get(ctx.expr(0));
        double rhs = values.get(ctx.expr(1));
        values.put(ctx, ctx.op.getType() == CalcParser.ADD ? lhs + rhs : lhs - rhs);
    }

    // expr : '(' expr ')' ;
    @Override
    public void exitParen(CalcParser.ParenContext ctx) {
        values.put(ctx, values.get(ctx.expr()));
    }
}
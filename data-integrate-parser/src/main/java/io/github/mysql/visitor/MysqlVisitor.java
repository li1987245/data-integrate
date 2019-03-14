package io.github.mysql.visitor;

import io.github.mysql.MySqlParser;
import io.github.mysql.MySqlParserBaseVisitor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MysqlVisitor extends MySqlParserBaseVisitor {


    @Override
    public Object visitQuerySpecification(MySqlParser.QuerySpecificationContext ctx) {
        String select = ctx.selectElements().getText();
        log.info("select:{}", select);
        ctx.selectSpec().forEach(s->{
            log.info("spec:{}",s.getText());
        });
        String from = ctx.fromClause().getText();
        log.info("from:{}", from);
        return super.visitQuerySpecification(ctx);
    }

    @Override
    public Object visitTableName(MySqlParser.TableNameContext ctx) {
        return super.visitTableName(ctx);
    }

    /**
     * 5
     * @param ctx
     * @return
     */
    @Override
    public Object visitTableSources(MySqlParser.TableSourcesContext ctx) {
        ctx.tableSource().forEach(t->{
            log.info("table:{}",t.getText());
        });
        return super.visitTableSources(ctx);
    }

    @Override
    public Object visitTableSourceBase(MySqlParser.TableSourceBaseContext ctx) {
        ctx.joinPart().forEach(j->{
            log.info("join:{}",j.getText());
            j.children.forEach(p->{
                log.info("part:{}",p.getText());
            });
        });
        return super.visitTableSourceBase(ctx);
    }

    @Override
    public Object visitTableSourcesItem(MySqlParser.TableSourcesItemContext ctx) {
        return super.visitTableSourcesItem(ctx);
    }

    @Override
    public Object visitInnerJoin(MySqlParser.InnerJoinContext ctx) {
        return super.visitInnerJoin(ctx);
    }

    @Override
    public Object visitOuterJoin(MySqlParser.OuterJoinContext ctx) {

        System.out.println(ctx.tableSourceItem().getText()+"...."+ctx.expression().getText());
        return super.visitOuterJoin(ctx);
    }

    /**
     * 7
     * @param ctx
     * @return
     */
    @Override
    public Object visitOrderByClause(MySqlParser.OrderByClauseContext ctx) {
        return super.visitOrderByClause(ctx);
    }

    /**
     * 8
     * @param ctx
     * @return
     */
    @Override
    public Object visitOrderByExpression(MySqlParser.OrderByExpressionContext ctx) {
        return super.visitOrderByExpression(ctx);
    }

    @Override
    public Object visitSubqueryTableItem(MySqlParser.SubqueryTableItemContext ctx) {
        return super.visitSubqueryTableItem(ctx);
    }


    @Override
    public Object visitQueryExpression(MySqlParser.QueryExpressionContext ctx) {
        return super.visitQueryExpression(ctx);
    }

    /**
     * 1
     * @param ctx
     * @return
     */
    @Override
    public Object visitSelectSpec(MySqlParser.SelectSpecContext ctx) {
        return super.visitSelectSpec(ctx);
    }

    /**
     * 2
     * @param ctx
     * @return
     */
    @Override
    public Object visitSelectElements(MySqlParser.SelectElementsContext ctx) {
        return super.visitSelectElements(ctx);
    }

    /**
     * 3
     * @param ctx
     * @return
     */
    @Override
    public Object visitSelectColumnElement(MySqlParser.SelectColumnElementContext ctx) {
        return super.visitSelectColumnElement(ctx);
    }

    @Override
    public Object visitSelectExpressionElement(MySqlParser.SelectExpressionElementContext ctx) {
        return super.visitSelectExpressionElement(ctx);
    }

    /**
     * 4
     * @param ctx
     * @return
     */
    @Override
    public Object visitFromClause(MySqlParser.FromClauseContext ctx) {
        return super.visitFromClause(ctx);
    }

    /**
     * 6
     * @param ctx
     * @return
     */
    @Override
    public Object visitGroupByItem(MySqlParser.GroupByItemContext ctx) {
        return super.visitGroupByItem(ctx);
    }

    /**
     * 9
     * @param ctx
     * @return
     */
    @Override
    public Object visitLimitClause(MySqlParser.LimitClauseContext ctx) {
        return super.visitLimitClause(ctx);
    }


}

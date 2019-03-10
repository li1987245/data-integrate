import io.github.calc.CalcLexer;
import io.github.calc.CalcParser;
import io.github.calc.listener.Evaluator;
import io.github.calc.visitor.EvalVisitor;
import io.github.mysql.MySqlLexer;
import io.github.mysql.MySqlParser;
import io.github.mysql.utils.UpperCaseCharStream;
import io.github.mysql.visitor.MysqlVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

/**
 * @description
 * @author: jinwei.li@100credit.com
 * @date: 2019/3/9 10:36
 */
public class BasicTest {
    @Test
    public void testCalc() throws Exception {
        CharStream charStreams = CharStreams.fromStream(getClass().getResourceAsStream("/1.txt"));
        CalcLexer lexer = new CalcLexer(charStreams);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalcParser parser = new CalcParser(tokens);
        ParseTree tree = parser.calc();

        System.out.println("LISP:");
        System.out.println(tree.toStringTree(parser));
        System.out.println();

        System.out.println("Visitor:");
        EvalVisitor evalByVisitor = new EvalVisitor();
        Double d = evalByVisitor.visit(tree);
        System.out.println(d);

        System.out.println("Listener:");
        ParseTreeWalker walker = new ParseTreeWalker();
        Evaluator evalByListener = new Evaluator();
        walker.walk(evalByListener, tree);
    }

    @Test
    public void testMysql() throws Exception {
        CharStream charStreams = new UpperCaseCharStream(CharStreams.fromString("select distinct t1.comp_name compName,t.api_code apiCode,sum(t.payment) payments from dms_payment t left join $.dms_company t1 on t.id=t1.t_id where t1.comp_name='测试' group by t1.comp_name,t.api_code order by t.api_code limit 10"));
        MySqlLexer lexer = new MySqlLexer(charStreams);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MySqlParser parser = new MySqlParser(tokens);
        MySqlParser.RootContext tree = parser.root();

        System.out.println("LISP:");
        System.out.println(tree.toStringTree(parser));
        System.out.println();
        System.out.println("Visitor:");
        MysqlVisitor visitor = new MysqlVisitor();
        visitor.visit(tree);
    }
}

import io.github.CalcLexer;
import io.github.CalcParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
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

//        System.out.println("Visitor:");
//        EvalVisitor evalByVisitor = new EvalVisitor();
//        evalByVisitor.visit(tree);
//        System.out.println();
//
//        System.out.println("Listener:");
//        ParseTreeWalker walker = new ParseTreeWalker();
//        Evaluator evalByListener = new Evaluator();
//        walker.walk(evalByListener, tree);
    }
}

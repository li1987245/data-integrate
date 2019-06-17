package io.github;

import lombok.extern.slf4j.Slf4j;

import javax.script.*;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Test {

    public static void main(String[] args) throws Exception {
        test();
    }

    private static void test() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(50);
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        Compilable compilable = (Compilable) engine;
        CompiledScript compiledScript = compilable.compile(new FileReader("F:\\IdeaProjects\\JWorks\\short-link\\src\\main\\resources\\example.js"));
        CountDownLatch latch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            executor.execute(new ScriptRunnable(compiledScript, i, latch));
        }
        latch.await();
    }

    static class ScriptRunnable implements Runnable {
        private CompiledScript compiledScript;
        private int i;
        private CountDownLatch latch;

        public ScriptRunnable(CompiledScript compiledScript, int i, CountDownLatch latch) {
            this.compiledScript = compiledScript;
            this.i = i;
            this.latch = latch;
        }

        @Override
        public void run() {
            ScriptContext scriptContext = new SimpleScriptContext();
            Bindings bindings = scriptContext.getBindings(ScriptContext.ENGINE_SCOPE);
            bindings.put("paramJson", "{'api_code':'-1','swift_number':'yu_20141010103651_0402','ruleList':['Rule_C_EquipmentCallLog'],'purchaseDatas':{'EquipmentCallLog':{'cardtype':'移动','is_vnumber':'0','attribution':'天津','is_calllog':'1','phone_num':'10','linkman_num':'8','noame_num':'','cell_num':'5','cell3_num':'"+i+"','fraudcell_num':'','centracity':'北京','family_occ':'1','collection_occ':'','loan_occ':'','gambling_occ':'','court_occ':'1','lawyer_occ':'1','family_num':'1','collection_num':'1','loan_num':'10','gambling_num':'1','court_num':'1','lawyer_num':'1','caller_macd_citys':'北京,天津,哈尔滨,呼和浩特,保定','callee_macd_citys':'北京,天津,哈尔滨','usual_callerno':'13330593780,18789796578,18778899642,13261786642','is_usual_callerno':'1','usual_callerno_lost':'1','usual_callerno_lost_num':'2','usual_callerno_lost_perc':'','usual_callerno_bad':'2','usual_callerno_bad_num':'5','usual_callerno_bad_perc':'11.98','m1':{'cont_linkman_num':'10','tot_num':'17','tot_mins':'03:24:22','tot_peop':'4','night_num':'','night_perc':'','night_mins':'02:33:45','night_peop':'6','caller_perc':'0.8','callee_perc':'30','noname_perc':'67.73','max_nocont_day':'10','ltime_nocont_num':''}}}}");
            try {
                compiledScript.eval(scriptContext);
                Thread.sleep(new Random().nextInt(1000));
                Object o = compiledScript.getEngine().eval("function f(){return i_eqcl_cell3_num};f()",scriptContext);
                log.error("{},{},{}", i, o, i == Integer.parseInt(o.toString()));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }
    }


    private static void test0() throws Exception {
        Map<String, Object> vars = new HashMap<>();
        final String paramJson = "{'api_code':'-1','swift_number':'yu_20141010103651_0402','ruleList':['Rule_C_EquipmentCallLog'],'purchaseDatas':{'EquipmentCallLog':{'cardtype':'移动','is_vnumber':'0','attribution':'天津','is_calllog':'1','phone_num':'10','linkman_num':'8','noame_num':'','cell_num':'5','cell3_num':'11','fraudcell_num':'','centracity':'北京','family_occ':'1','collection_occ':'','loan_occ':'','gambling_occ':'','court_occ':'1','lawyer_occ':'1','family_num':'1','collection_num':'1','loan_num':'10','gambling_num':'1','court_num':'1','lawyer_num':'1','caller_macd_citys':'北京,天津,哈尔滨,呼和浩特,保定','callee_macd_citys':'北京,天津,哈尔滨','usual_callerno':'13330593780,18789796578,18778899642,13261786642','is_usual_callerno':'1','usual_callerno_lost':'1','usual_callerno_lost_num':'2','usual_callerno_lost_perc':'','usual_callerno_bad':'2','usual_callerno_bad_num':'5','usual_callerno_bad_perc':'11.98','m1':{'cont_linkman_num':'10','tot_num':'17','tot_mins':'03:24:22','tot_peop':'4','night_num':'','night_perc':'','night_mins':'02:33:45','night_peop':'6','caller_perc':'0.8','callee_perc':'30','noname_perc':'67.73','max_nocont_day':'10','ltime_nocont_num':''}}}}";
        vars.put("paramJson", paramJson);
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        ScriptContext context = engine.getContext();
        Bindings bindings = context.getBindings(ScriptContext.ENGINE_SCOPE);
        bindings.putAll(vars);
        Compilable compilable = (Compilable) engine;
        CompiledScript compiledScript = compilable.compile(new FileReader("F:\\IdeaProjects\\JWorks\\short-link\\src\\main\\resources\\example.js"));
        Object o = compiledScript.eval();
        System.out.println(o);
        o = compiledScript.eval(bindings);
        System.out.println(o);
        o = compiledScript.getEngine().eval("function f(){return i_eqcl_cell3_num};f()");
        System.out.println(o);
        Invocable invocable = (Invocable) compiledScript.getEngine();
        o = invocable.invokeFunction("test", "i_eqcl_cell3_num");
        System.out.println(o);
    }

    private static void test1() throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        ScriptContext scriptContext = new SimpleScriptContext();
        Bindings bindings = scriptContext.getBindings(ScriptContext.ENGINE_SCOPE);
        bindings.put("paramJson", "{'api_code':'-1','swift_number':'yu_20141010103651_0402','ruleList':['Rule_C_EquipmentCallLog'],'purchaseDatas':{'EquipmentCallLog':{'cardtype':'移动','is_vnumber':'0','attribution':'天津','is_calllog':'1','phone_num':'10','linkman_num':'8','noame_num':'','cell_num':'5','cell3_num':'11','fraudcell_num':'','centracity':'北京','family_occ':'1','collection_occ':'','loan_occ':'','gambling_occ':'','court_occ':'1','lawyer_occ':'1','family_num':'1','collection_num':'1','loan_num':'10','gambling_num':'1','court_num':'1','lawyer_num':'1','caller_macd_citys':'北京,天津,哈尔滨,呼和浩特,保定','callee_macd_citys':'北京,天津,哈尔滨','usual_callerno':'13330593780,18789796578,18778899642,13261786642','is_usual_callerno':'1','usual_callerno_lost':'1','usual_callerno_lost_num':'2','usual_callerno_lost_perc':'','usual_callerno_bad':'2','usual_callerno_bad_num':'5','usual_callerno_bad_perc':'11.98','m1':{'cont_linkman_num':'10','tot_num':'17','tot_mins':'03:24:22','tot_peop':'4','night_num':'','night_perc':'','night_mins':'02:33:45','night_peop':'6','caller_perc':'0.8','callee_perc':'30','noname_perc':'67.73','max_nocont_day':'10','ltime_nocont_num':''}}}}");
        Compilable compilable = (Compilable) engine;
        CompiledScript compiledScript = compilable.compile(new FileReader("F:\\IdeaProjects\\JWorks\\short-link\\src\\main\\resources\\example.js"));
        Object o = compiledScript.eval(scriptContext);
        System.out.println(o);
        o = compiledScript.eval(bindings);
        System.out.println(o);
        o = compiledScript.getEngine().eval("function f(){return i_eqcl_cell3_num};f()", scriptContext);
        System.out.println(o);
    }

}

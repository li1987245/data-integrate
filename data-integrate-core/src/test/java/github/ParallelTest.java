package github;

import io.github.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ParallelTest {

    private final static int parallel = 10;

    @Test
    public void testHttp(){
        String str =  HttpUtil.sendGet("http://127.0.0.1:8088/hello");
        System.out.println(str);
    }

    @Test
    public void testHttpRequest() throws InterruptedException {
        int cycle = parallel*50;
        StopWatch stopWatch = StopWatch.createStarted();
        ExecutorService executor = getExecutorService();
        CountDownLatch latch = new CountDownLatch(cycle);
        for (int i=0;i<cycle;i++){
            executor.submit(()->{
                try {
                    String str =  HttpUtil.sendGet("http://127.0.0.1:8088/hello");
                    log.debug("response data:{}",str);
                    Assert.assertEquals(str,"Hello 阿达的");
                }
                catch (Exception e){
                    log.error("",e);
                }
                finally {
                    latch.countDown();
                }

            });
        }
        latch.await();
        long seconds =  stopWatch.getTime(TimeUnit.SECONDS);
        System.out.println(seconds);
    }



    private ExecutorService getExecutorService(){
        return Executors.newFixedThreadPool(parallel);
    }
}

package github;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Author: jinwei.li@100credit.com
 * @Date: 2018/8/29 10:58
 */
public class ThreadTest {

    private static final int SIZE = 1000;

    @Test
    public void testThreadPool() throws InterruptedException {
//        Executor executor = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        Executor executor = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(SIZE);
        System.out.println("begin time:" +System.currentTimeMillis());
        for (int i = 0; i < SIZE; i++) {
            executor.execute(new AccumulateRunnable(i, latch));
        }
        latch.await();
        System.out.println("end time:"+ System.currentTimeMillis());
    }

    class AccumulateRunnable implements Runnable {
        private int time;
        private CountDownLatch latch;

        AccumulateRunnable(int t, CountDownLatch latch) {
            this.time = t;
            this.latch = latch;
        }

        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(Thread.currentThread().getName()+"---"+time);
            latch.countDown();
        }
    }
}

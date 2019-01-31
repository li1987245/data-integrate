package github;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * @Author: jinwei.li@100credit.com
 * @Date: 2018/8/29 10:58
 */
public class ThreadTest {

    private static final int SIZE = 100;

    @Test
    public void testThreadPool() throws Exception {
//        Executor executor = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        Executor executor = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(SIZE);
        System.out.println("begin time:" + System.currentTimeMillis());
        for (int i = 0; i < SIZE; i++) {
            executor.execute(new AccumulateRunnable(i, latch));
        }
        latch.await();
        System.out.println("end time:" + System.currentTimeMillis());
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
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
            System.out.println(Thread.currentThread().getName() + "---" + time);
            latch.countDown();
        }
    }

    @Test
    public void testForkJoin() throws Exception {
        ForkJoinPool forkJoinPool = new ForkJoinPool(8);
        int[] test = {9, 2, 6, 3, 5, 7, 10, 11, 1,2};
        SubTask st =   new SubTask(test, 0, test.length - 1);
        Future<Void> result =  forkJoinPool.submit(st);
        result.get();
        Arrays.stream(test).forEach(System.out::println);
    }

    class SubTask extends RecursiveAction {
        static final int THRESHOLD = 2;
        int[] arr;
        int start;
        int end;

        SubTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (arr == null || arr.length == 0)
                throw new RuntimeException("error");
            if (end - start <= THRESHOLD) {
                mergeSort(arr, start, end);
                return;
            }
            int mid = (start + end)/2;
            SubTask st1 = new SubTask(arr, start, mid);
            SubTask st2 = new SubTask(arr, mid + 1, end);
            invokeAll(st1,st2);
            merge(arr, start, mid, end);
        }
    }


    @Test
    public void testMergeSort() {
        int[] test = {9, 2, 6, 3, 5, 7, 10, 11, 1, 2};
        mergeSort(test, 0, test.length - 1);
        Arrays.stream(test).forEach(System.out::println);
    }

    private void mergeSort(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0)
            return;
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= end) {
            tmp[k++] = arr[j++];
        }
        for (int v : tmp) {
            arr[start++] = v;
        }

    }
}

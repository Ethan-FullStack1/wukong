package atomiclong;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 演示高并发场景下，LongAdder比AtomicLong性能好
 *
 * @author 多宝
 * @since 2021/2/10 0:37
 */
public class AtomicLongDemo {

    public static void main(String[] args) {
        AtomicLong counter = new AtomicLong(0);

        // 创建线程池，来执行不同线程上的任务
        ExecutorService threadPool = Executors.newFixedThreadPool(20);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            threadPool.submit(new Task(counter));
        }

        threadPool.shutdown();
        while (!threadPool.isTerminated()){

        }
        long end = System.currentTimeMillis();
        System.out.println(counter.get());
        System.out.println("AtomicLong耗时" + (end - start));
    }

    private static class Task implements Runnable {

        private final AtomicLong counter;

        public Task(AtomicLong counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter.incrementAndGet();
            }
        }
    }

}

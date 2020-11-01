package ShutDownThread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 基本关闭线程池
 *
 * @author 多宝
 * @since 2020/10/25 5:28
 */
public class ShutDown {

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new ShutDownTask());
        }
        Thread.sleep(1500);
        List<Runnable> list = executorService.shutdownNow();
//        System.out.println(executorService.isShutdown());
//        executorService.shutdown();
//        System.out.println(executorService.isShutdown());
//        System.out.println(executorService.isTerminated());
//        executorService.execute(new ShutDownTask());
//        executorService.awaitTermination(3L, TimeUnit.SECONDS);
    }
}

class ShutDownTask implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println("被中断了" + Thread.currentThread().getName());
        }

    }
}

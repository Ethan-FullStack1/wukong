package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示最大线程堆积线程队列出现内存不够用
 * 演示newThreadPool出错的情况
 *
 * @author 多宝
 * @since 2020/10/25 4:33
 */
public class FixedThreaPoolOOM {
    public static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executorService.execute(new SubThread());
        }
    }
}


class SubThread implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
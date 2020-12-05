package lock.reentrantlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示公平锁的情况，以及是非公平锁的两种情况
 *
 * @author 多宝
 * @since 2020/11/8 23:00
 */
public class FairLock {

    public static void main(String[] args) {
        PrintQueue queue = new PrintQueue();
        // 用数组的形式创建10个线程
        Thread[] thread = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(queue));
        }
        for (int i = 0; i < 10; i++) {
            thread[i].start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


class PrintQueue {
    // 由于我们的打印机只有一台，所以我们来定义一把锁
    private static final Lock queueLock = new ReentrantLock(false);

    // 打印的方法
    public void printJob(Object document) {
        queueLock.lock();
        try {
            // 模拟打印需要的时长
            int duration = new Random().nextInt(10) + 1;
            System.out.println(Thread.currentThread().getName() + "正在打印，需要" + duration + "秒");
            // 模拟耗时
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }

        // 模拟有两张纸需要打印
        queueLock.lock();
        try {
            // 模拟打印需要的时长
            int duration = new Random().nextInt(10) + 1;
            System.out.println(Thread.currentThread().getName() + "正在打印，需要" + duration + "秒");
            // 模拟耗时
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }

    }
}

class Job implements Runnable {

    PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始打印");
        printQueue.printJob(new Object());
        System.out.println(Thread.currentThread().getName() + "打印完毕");
    }
}
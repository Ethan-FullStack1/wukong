package lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 多宝
 * @since 2020/11/1 21:38
 */
public class LockInterruptibly implements Runnable {

    private final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockInterruptibly interruptibly = new LockInterruptibly();
        Thread thread0 = new Thread(interruptibly);
        Thread thread1 = new Thread(interruptibly);
        thread0.start();
        thread1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread0.interrupt();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "尝试获取锁");
        try {
            lock.lockInterruptibly();
            // 拿到锁之后首先要做的就是try ... finally
            try {
                System.out.println(Thread.currentThread().getName() + "获取到了锁");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "睡眠期间被中断了");
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放了锁");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "获取锁时间被中断");
        }
    }
}

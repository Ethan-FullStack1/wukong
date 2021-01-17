package lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 演示非公平的读写锁的插队情况
 *
 * @author 多宝
 * @since 2020/12/5 23:25
 */
public class NonfairBargeChaDuiDemo {

    // 创建一个非公平的读写锁
    private static final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(false);

    // 创建一个读锁
    private static final ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();

    // 创建一个写锁
    private static final ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    /**
     * 读锁读取操作
     *
     * @author 多宝
     * @since 2021/1/10 6:12
     */
    public static void read() {
        System.out.println(Thread.currentThread().getName() + "开始尝试获取读锁");
        // 让线程获取到读锁
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到读锁，正在读取");
            // 假设读取时间为20毫秒
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            // 释放锁之前，给个提示
            System.out.println(Thread.currentThread().getName() + "释放读锁");
            readLock.unlock();
        }
    }

    /**
     * 写入锁操作
     *
     * @author 多宝
     * @since 2021/1/10 6:18
     */
    public static void write() {
        System.out.println(Thread.currentThread().getName() + "开始尝试获取写锁");
        // 让线程获取到读锁
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到写入锁，正在写入");
            // 假设读取时间为20毫秒
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            // 释放锁之前，给个提示
            System.out.println(Thread.currentThread().getName() + "释放写入锁");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(NonfairBargeChaDuiDemo::write, "Thread1").start();
        new Thread(NonfairBargeChaDuiDemo::read, "Thread2").start();
        new Thread(NonfairBargeChaDuiDemo::read, "Thread3").start();
        new Thread(NonfairBargeChaDuiDemo::write, "Thread4").start();
        new Thread(NonfairBargeChaDuiDemo::read, "Thread5").start();

        // 创造一些插队的线程
        new Thread(() -> {
            Thread[] threads = new Thread[1000];
            for (int i = 0; i < 1000; i++) {
                threads[i] = new Thread(NonfairBargeChaDuiDemo::read, "子线程创建的Thread" + i);
            }
            for (int i = 0; i < 1000; i++) {
                threads[i].start();
            }
        }).start();
    }

}



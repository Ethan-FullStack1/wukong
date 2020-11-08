package lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁代码演示
 *
 * @author 多宝
 * @since 2020/11/8 21:23
 */
public class GetHoldCount {

    private final static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        // 打印出锁已经被拿到几次
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }


}

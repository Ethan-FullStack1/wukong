package lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 递归演示可重入锁的复杂作用
 *
 * @author 多宝
 * @since 2020/11/8 21:28
 */
public class RecursionDemo {

    private static final ReentrantLock lock = new ReentrantLock();

    /**
     * 获取资源
     *
     * @author 多宝
     * @since 2020/11/8 21:29
     */
    private static void accessResource() {
        lock.lock();
        try {
            System.out.println("已经对资源进行了处理");
            if (lock.getHoldCount() < 5) {
                System.out.println(lock.getHoldCount());
                accessResource();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        accessResource();
    }
}

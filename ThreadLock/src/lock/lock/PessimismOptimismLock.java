package lock.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 多宝
 * @since 2020/11/7 17:21
 */
public class PessimismOptimismLock {

    // a不是线程安全的
    int a;

    /**
     * 乐观锁实现
     *
     * @author 多宝
     * @since 2020/11/7 17:24
     * @param args  参数
     */
    public static void main(String[] args) {
        // 创建一个原子类
        // 创建一个原子整形
        AtomicInteger integer = new AtomicInteger();
        // 让原子整形进行自增
        // 这个原子整形也可以允许多个线程来5耳
        integer.incrementAndGet();
    }


    /**
     * 悲观锁的实现来同步方法
     * 执行完逻辑别的线程才能进来，不然不允许其他线程操作
     *
     * @author 多宝
     * @since 2020/11/7 17:22
     */
    public synchronized void testMethod() {
        // 多个线程如果同时来操作当前方法，如果是不加synchronized的话，a++就会发生线程错误
        // 所以你加了synchronized来保证了线程的安全
        a++;
    }

}

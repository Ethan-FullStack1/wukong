package lock.spinblocking;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 简单实现一种自旋锁
 *
 * @author 多宝
 * @since 2021/1/17 12:53
 */
public class SpinLock {

    // 创建一个原子引用
    private AtomicReference<Thread> sign = new AtomicReference<>();

    private void lock() {
        // 拿到当前线程的引用
        Thread current = Thread.currentThread();
        // 创建一个自旋的操作
        // 把我们期待的值和更新的值去放到入参里面
        while (!sign.compareAndSet(null, current)) {
            System.out.println(Thread.currentThread().getName() + "自旋获取失败，再次尝试获取");
        }
    }

    private void unlock() {
        // 拿到当前线程的引用
        Thread current = Thread.currentThread();
        sign.compareAndSet(current,null);
    }

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "开始尝试获取自旋锁");
            spinLock.lock();
            System.out.println(Thread.currentThread().getName() + "获取到了自旋锁");
            // 模拟处理
            try {
                Thread.sleep(300);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放了自旋锁");
                spinLock.unlock();
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }

}

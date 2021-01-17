package lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 锁的升降级
 *
 * @author 多宝
 * @since 2021/1/17 11:01
 */
public class Upgrading {

    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(false);

    private static final ReentrantReadWriteLock.ReadLock READ_LOCK = readWriteLock.readLock();

    private static final ReentrantReadWriteLock.WriteLock WRITE_LOCK = readWriteLock.writeLock();

    /**
     * 测试读锁能不能升级
     *
     * @author 多宝
     * @since 2021/1/17 11:07
     */
    private static void readUpgrading() {
        READ_LOCK.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "拿到读锁，正在读取");
            Thread.sleep(1000);
            // 读取完毕之后先不释放锁，读取完毕尝试升级锁(获取写锁)
            System.out.println("升级会带来阻塞");
            WRITE_LOCK.lock();
            System.out.println(Thread.currentThread().getName() + "成功获取到了写锁，升级成功");
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了读锁");
            READ_LOCK.unlock();
        }
    }

    /**
     * 演示写锁能不能降级
     *
     * @author 多宝
     * @since 2021/1/17 11:14
     */
    private static void writeDownGrading() {
        WRITE_LOCK.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取到了写锁，正在写入");
            Thread.sleep(1000);
            // 写锁执行写入完毕之后，尝试获取读锁(锁的降级)
            READ_LOCK.lock();
            System.out.println("在不释放写锁的情况下，获取到了读锁，成功降级");
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            READ_LOCK.unlock();
            System.out.println(Thread.currentThread().getName() + "释放了写锁");
            WRITE_LOCK.unlock();
        }
    }

     public static void main(String[] args) {
        /*System.out.println("先演示降级是可以的");
        Thread thread1 = new Thread(Upgrading::writeDownGrading, "Thread1");
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }*/

        System.out.println("演示升级是不行的");
        Thread thread2 = new Thread(Upgrading::readUpgrading, "thread2");
        thread2.start();
    }
}

package lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 演示购买电影票读写锁的使用方法
 *
 * @author 多宝
 * @since 2020/12/5 22:10
 */
public class CinemaReadWrite {

    // 创建一把读写锁
    private static final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    // 创建一把读锁和一把写锁
    // 创建一把读锁
    private static final ReentrantReadWriteLock.ReadLock READ_LOCK = reentrantReadWriteLock.readLock();
    // 创建一把写锁
    private static final ReentrantReadWriteLock.WriteLock WRITE_LOCK = reentrantReadWriteLock.writeLock();

    /**
     * 只查看电影票，不去做那些买票的修改操作
     *
     * @author 多宝
     * @since 2020/12/5 22:16
     */
    private static void read() {
        // 首先拿到读锁
        READ_LOCK.lock();
        // 操作锁之前，先释放掉锁 try {} finally{}
        try {
            System.out.println(Thread.currentThread().getName() + "得到了读锁，正在读取");
            // 假设读取的时间为1秒
            Thread.sleep(1000);
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了读锁");
            READ_LOCK.unlock();
        }
    }

    /**
     * 演示写锁
     *
     * @author 多宝
     * @since 2020/12/5 22:22
     */
    private static void write() {
        // 首先拿到读锁
        WRITE_LOCK.lock();
        // 操作锁之前，先释放掉锁 try {} finally{}
        try {
            System.out.println(Thread.currentThread().getName() + "得到了写锁，正在写入");
            // 假设读取的时间为1秒
            Thread.sleep(1000);
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了写锁");
            WRITE_LOCK.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(CinemaReadWrite::read,"threa1").start();
        new Thread(CinemaReadWrite::read,"threa2").start();
        new Thread(CinemaReadWrite::write,"threa3").start();
        new Thread(CinemaReadWrite::write,"threa4").start();
    }


}

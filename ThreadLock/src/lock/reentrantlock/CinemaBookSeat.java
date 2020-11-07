package lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示ReentrantLock模拟电影院预定座位场景
 *
 * @author 多宝
 * @since 2020/11/7 18:17
 */
public class CinemaBookSeat {
    private static final ReentrantLock lock = new ReentrantLock();

    private static void bookSeat() {
        // 首先你拿到电影院的这个座位，说明你拿到了这个锁
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始预定座位");
            // 假设预定座位要花费一秒钟的时间，我们就用sleep来模拟这个效果
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "完成预定座位");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        new Thread(CinemaBookSeat::bookSeat).start();
        new Thread(CinemaBookSeat::bookSeat).start();
        new Thread(CinemaBookSeat::bookSeat).start();
        new Thread(CinemaBookSeat::bookSeat).start();
    }

}

package lock.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示ReentrantLock的基本用法，演示被打断
 *
 * @author 多宝
 * @since 2020/11/7 18:17
 */
public class LockDemo {

    public static void main(String[] args) {
        new LockDemo().init();
    }

    private void init() {
        OutPuter outPuter = new OutPuter();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outPuter.output("杨得宝");
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outPuter.output("杨得宝真帅");
            }
        }).start();
    }


    static class OutPuter {
        Lock lock = new ReentrantLock();

        // 字符串打印方法，一个个字符的打印
        public void output(String name) {
            int length = name.length();
            lock.lock();    // 这里使用锁和不使用会出现能不能保证字符串完整性
            try {
                for (int i = 0; i < length; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println("");
            } finally {
                lock.unlock();
            }
        }
    }

}

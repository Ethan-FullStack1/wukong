package EquivalentCode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示AtomicInteger利用的CAS操作
 *
 * @author 多宝
 * @since 2021/2/10 20:57
 */
public class AtomicIntegerCAS implements Runnable {

    private volatile int value;

    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectedValue) {
            value = newValue;
        }
        return oldValue;
    }

    public static void main(String[] args) throws Exception{

        new AtomicInteger();

        AtomicIntegerCAS r = new AtomicIntegerCAS();
        r.value = 0;
        Thread t1 = new Thread(r,"thread1");
        Thread t2 = new Thread(r,"thread2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(r.value);
    }

    @Override
    public void run() {
        compareAndSwap(0, 1);
    }
}

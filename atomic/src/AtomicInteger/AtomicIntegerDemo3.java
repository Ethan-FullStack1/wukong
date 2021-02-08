package AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  原子类减少
 *
 * @author 多宝
 * @since 2021/2/8 14:32
 */
public class AtomicIntegerDemo3 implements Runnable {

    private static final AtomicInteger atomicInteger = new AtomicInteger();

    public void incrementAtomic() {
        atomicInteger.getAndDecrement();
    }

    private static volatile int basicCount = 0;

    public void incrementBasic(){
        basicCount++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            incrementAtomic();
            incrementBasic();
        }
    }

    public static void main(String[] args) throws Exception{
        AtomicIntegerDemo3 thisClass = new AtomicIntegerDemo3();
        Thread t1 = new Thread(thisClass);
        Thread t2 = new Thread(thisClass);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("原子类的结果是：" + atomicInteger.get());
        System.out.println("普通变量的结果：" + basicCount);
    }
}

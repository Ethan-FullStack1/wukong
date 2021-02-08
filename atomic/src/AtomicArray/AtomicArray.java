package AtomicArray;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 原子数组
 *
 * @author 多宝
 * @since 2021/2/8 15:10
 */
public class AtomicArray {

    public static void main(String[] args) {
        AtomicIntegerArray array = new AtomicIntegerArray(1000);
        Increment increment = new Increment(array);
        Decrement decrement = new Decrement(array);
        Thread[] threadsIncrement = new Thread[100];
        Thread[] threadsDecrement = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threadsDecrement[i] = new Thread(decrement);
            threadsIncrement[i] = new Thread(increment);

            threadsDecrement[i].start();
            threadsIncrement[i].start();
        }

        for (int i = 0; i < 100; i++) {
            try {
                threadsDecrement[i].join();
                threadsIncrement[i].join();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }

        for (int i = 0; i < array.length(); i++) {
            if (array.get(i) != 0){
                System.out.println("发现了错误" + i);
            }
        }
        System.out.println("运行结束");
    }

}

class Decrement implements Runnable {

    private AtomicIntegerArray array;

    public Decrement(AtomicIntegerArray array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndDecrement(i);
        }
    }
}

class Increment implements Runnable {

    private AtomicIntegerArray array;

    public Increment(AtomicIntegerArray array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndIncrement(i);
        }
    }
}

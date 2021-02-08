package AtomicIntegerFieldUpdater;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 基本数据类型升级原子数据类型
 * 演示FieldUpdater的用法
 *
 * @author 多宝
 * @since 2021/2/8 16:17
 */
public class AtomicIntegerFieldUpdaterDemo implements Runnable {
    static Candidate tom;
    static Candidate peter;

    public static AtomicIntegerFieldUpdater<Candidate> scoreUpdater = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            peter.score++;
            scoreUpdater.getAndIncrement(tom);
        }
    }

    public static class Candidate {
        volatile int score;
    }

    public static void main(String[] args) throws Exception {
        tom = new Candidate();
        peter = new Candidate();
        AtomicIntegerFieldUpdaterDemo r = new AtomicIntegerFieldUpdaterDemo();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("普通变量" + peter.score);
        System.out.println("升级后的结果" + tom.score);
    }

}

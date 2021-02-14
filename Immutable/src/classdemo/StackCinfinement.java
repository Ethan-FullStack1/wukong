package classdemo;

/**
 * 演示栈封闭的两种情况，基本变量和对象
 * 先演示线程带来错误结果，然后把变量放到方法内，
 * 情况就变了
 *
 * @author 多宝
 * @since 2021/2/14 19:07
 */
public class StackCinfinement implements Runnable {

    int index = 0;

    public void inThread() {
        int neverGoOut = 0;
        for (int i = 0; i < 10000; i++) {
            neverGoOut++;
        }
        System.out.println("栈内保护的数字是线程安全的" + neverGoOut);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            index++;
        }
        inThread();
    }

    public static void main(String[] args) throws Exception{
        StackCinfinement cinfinement = new StackCinfinement();
        Thread t1 = new Thread(cinfinement);
        Thread t2 = new Thread(cinfinement);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(cinfinement.index);
    }

}

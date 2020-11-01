package ThreadPool;

/**
 * 每个任务一个线程
 *
 * @author 多宝
 * @since 2020/10/25 3:10
 */
public class EveryTaskOneThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new Tash());
        thread.start();
    }

    static class Tash implements Runnable{
        @Override
        public void run() {
            System.out.println("执行了任务！！");
        }
    }
}

package threadlocal.unthreadlcoal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1000个打印日期的任务，用线程池来执行
 *
 * @author 多宝
 * @since 2020/10/25 16:29
 */
public class ThreadLocalNormalUsage02 {

    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            threadPool.submit(() -> {
                String date = new ThreadLocalNormalUsage02().date(finalI);
                System.out.println(date);
            });
        }
        threadPool.shutdown();
    }


    /**
     * @param seconds 秒
     * @return java.lang.String
     * @author 多宝
     * @since 2020/10/25 16:31
     */
    public String date(int seconds) {
        // 参数的单位是毫秒，从1970.01.01 00:00:00   GMT计时
        Date date = new Date(seconds * 1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }

}

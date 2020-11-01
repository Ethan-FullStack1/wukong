package threadlocal.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 利用ThreadLocal,给每个线程分配自己的dateFormat对象，保证了线程安全，而且高效的利用了内存
 *
 * @author 多宝
 * @since 2020/10/25 16:29
 */
public class ThreadLocalNormalUsage00 {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(() -> {
                String date = new ThreadLocalNormalUsage00().date(finalI);
                System.out.println(date);
            }).start();
            Thread.sleep(100);
        }

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
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        SimpleDateFormat dateFormat = ThreadSafeFormatter.dateFormatThreadLocal.get();
        SimpleDateFormat dateFormat = ThreadSafeFormatter.dateFormatThreadLocalLambda.get();
        return dateFormat.format(date);
    }

}


class ThreadSafeFormatter {
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
    };

    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocalLambda = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));


}
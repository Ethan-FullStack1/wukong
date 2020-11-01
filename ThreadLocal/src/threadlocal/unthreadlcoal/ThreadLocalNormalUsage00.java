package threadlocal.unthreadlcoal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用两个线程分别打印生日信息
 *
 * @author 多宝
 * @since 2020/10/25 16:29
 */
public class ThreadLocalNormalUsage00 {

    public static void main(String[] args) {
        new Thread(() -> {
            String date = new ThreadLocalNormalUsage00().date(10);
            System.out.println(date);
        }).start();
        new Thread(() -> {
            String date = new ThreadLocalNormalUsage00().date(1007);
            System.out.println(date);
        }).start();
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

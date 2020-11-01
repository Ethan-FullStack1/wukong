package ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定时线程池使用演示
 *
 * @author 多宝
 * @since 2020/10/25 4:54
 */
public class ScheduledThreadPoolTest {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        //多长时间执行一次线程任务
//        executorService.schedule(new Task(),5, TimeUnit.SECONDS);
        //以一定频率重复运行(第一次一秒后执行，之后每隔3秒执行一次)
         executorService.scheduleAtFixedRate(new Task(),1,3,TimeUnit.SECONDS);
    }

}

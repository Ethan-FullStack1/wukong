package threadlocal.threadlocalnullpointerexception;

import com.sun.org.apache.bcel.internal.generic.LoadClass;

/**
 * 使用ThreadLocal出现NPE问题演示
 *
 * @author 多宝
 * @since 2020/10/31 22:17
 */
public class ThreadLocalNPE {

    ThreadLocal<Long> longThreadLcoal = new ThreadLocal<Long>();

    public void set() {
        longThreadLcoal.set(Thread.currentThread().getId());
    }

    public long get() {
        return longThreadLcoal.get();
    }

    public static void main(String[] args) {
        ThreadLocalNPE localNPE = new ThreadLocalNPE();

        // 这里直接拿出没有被设置值的ThreadLocal，应该拿到的是一个"null"，但是这里是报出空指针异常
        // 是因为我们定义的ThreadLcoal泛型是Long包装类型，get方法返回的是基本数据类型，在自动基本类型到包装类型自动装箱的时间出现了
        // 空指针异常
        System.out.println(localNPE.get());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                localNPE.set();
                System.out.println(localNPE.get());
            }
        });
        thread.start();
    }

}

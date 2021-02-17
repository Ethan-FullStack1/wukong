import java.util.HashMap;

/**
 * 演示HashMap在多线程情况下造成死循环的情况
 *
 * @author 多宝
 * @since 2021/2/16 19:16
 */
public class HashMapEndLessLoop {
    // hashMap的两个参数，一个初始容量，一个是负载因子
    // 负载因子会决定你在什么时候扩容
    public static HashMap<Integer, String> map = new HashMap<>(2, 1.5f);

    // 这个HashMap之所以设置2和1.5，这是我们需要让它在我们想要的地方扩容，
    // 因为死循环造成CPU100%的问题是体现在扩容的时候
    public static void main(String[] args) {
        map.put(5, "C");
        map.put(7, "B");
        map.put(3, "A");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    map.put(15, "D");
                    System.out.println(map);
                }
        }, "Thread 1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                map.put(1,"E");
                System.out.println(map);
            }
        },"Thread 2").start();


        // 我们现在负载因子是1.5，他的容量是2，他们相乘就是3.当Map里面有3个内容的时候
        // 它不会扩容，而变成4个的时候，他就会触发扩容，这个机制。

    }

}

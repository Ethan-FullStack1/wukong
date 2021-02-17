package predecesser;

import java.util.Vector;

/**
 * 演示Vector，主要是看Vector源码
 *
 * @author 多宝
 * @since 2021/2/15 13:09
 */
public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("test");
        System.out.println(vector.get(0));
    }

}

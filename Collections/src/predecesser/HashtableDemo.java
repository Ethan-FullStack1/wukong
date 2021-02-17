package predecesser;

import java.util.Hashtable;

/**
 * @author 多宝
 * @since 2021/2/15 13:25
 */
public class HashtableDemo {

    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<>();

        hashtable.put("学完以后跳槽涨薪幅度","50%");
        System.out.println(hashtable.get("学完以后跳槽涨薪幅度"));
    }

}

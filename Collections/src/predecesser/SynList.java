package predecesser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 演示Collections.synchronizedList(new ArrayList<E>())
 *
 * @author 多宝
 * @since 2021/2/15 13:40
 */
public class SynList {

    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        list.add(5);
        System.out.println(list.get(0));
    }

}

package classdemo;

import java.util.HashSet;
import java.util.Set;

/**
 * 一个属性是对象，但是整体不可变，其他类无法修改set里面的数据
 *
 * @author 多宝
 * @since 2021/2/14 18:54
 */
public class ImmutableDemo {

    private final Set<String> students = new HashSet<>();

    public ImmutableDemo() {
        students.add("李晓梅");
        students.add("王壮");
        students.add("徐福记");
    }

    public Boolean isStudent(String name){
        return students.contains(name);
    }

}

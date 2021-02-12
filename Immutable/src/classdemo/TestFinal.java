package classdemo;

/**
 * 测试Final能否被修改
 *
 * @author 多宝
 * @since 2021/2/12 21:02
 */
public class TestFinal {

    public static void main(String[] args) {

        Person person = new Person();

        int age = person.age;

        String name = person.name;
    }
}
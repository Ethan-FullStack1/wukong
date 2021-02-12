package finaldemo;

import classdemo.Person;

/**
 *
 * @author 多宝
 * @since 2021/2/12 21:46
 */
public class Demo1 {

    public static void main(String[] args) {
        // 如果我们在这里所创建的对象是final修饰的，这就以为着person
        // 指向的内容就不能变了
        final Person person = new Person();

        // 这就是说虽然我们的对象引用是不能变得，但是不会影响我们的对象
        // 里面的内容，对象里面的内容还是可以变化的。
        person.bag = "book";

    }

}

package classdemo;

/**
 * 不可变的对象，演示其他类无法修改这个对象，即便我们把它改成public也不行
 *
 * @author 多宝
 * @since 2021/2/12 21:00
 */
public class Person {

    final int age = 18;

    final String name = "Alice";

    public String bag = "computer";

    // 比如说你现在想增加一个普通的成员变量，那么后期啊这个分数是可能会被修改的。
    // 因为他并没有被final修饰，那如果你是这样一个Person对象啊，那么你不是不可
    // 变的，你是可变的，因为你有属性可变，只要你有任何一个属性可变，那么这就意
    // 味着你不具备不可变性。
    // 但是我们的Person是只有上面两个成员变量，并且都是靠final修饰的，他才是符
    // 合我们不可变的要求
//    int score = 0;

}

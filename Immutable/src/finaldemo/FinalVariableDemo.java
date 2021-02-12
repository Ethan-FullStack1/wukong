package finaldemo;

/**
 * 演示final变量
 *
 * @author 多宝
 * @since 2021/2/12 22:04
 */
public class FinalVariableDemo {
    // 第一种final变量赋值方法
//    private final int a = 6;


    // 第二种在构造函数中
//    private final int a;
//
//    public FinalVariableDemo(int a) {
//        this.a = a;
//    }

    // 第三种方法在代码块中将final变量赋值
    private final int a;
    {
        a = 6;
    }
}

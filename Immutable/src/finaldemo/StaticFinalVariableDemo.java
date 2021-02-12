package finaldemo;

/**
 * 演示Static的不可变变量初始化
 *
 * @author 多宝
 * @since 2021/2/12 22:13
 */
public class StaticFinalVariableDemo {

    // 第一种赋值方法
//    private static final int a = 1;

    //第二种赋值方法
    private static final int a;

    static {
        a = 7;
    }

}

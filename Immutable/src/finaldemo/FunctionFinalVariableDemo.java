package finaldemo;

/**
 * 演示方法中的final变量的赋值时机
 *
 * @author 多宝
 * @since 2021/2/12 22:13
 */
public class FunctionFinalVariableDemo {

    void testFinal() {
        // 由于b是没有赋值的，但是这里面是没有报错的，但是在使用之前是必须要被赋值的。
        final int b;

        b = 1;
        // 在这里面已经是被赋值了，但是你上面如果是不赋值的话，下面的使用就会报错
        int c = b;
    }

}

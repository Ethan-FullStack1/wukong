package finaldemo;

/**
 * 演示重写方法被final修饰
 *
 * @author 多宝
 * @since 2021/2/12 22:52
 */
public class FinalMethodDemo1 {

    public void drink() {

    }

    public final void eat() {

    }

    public static void sleep() {

    }

}

class SubClass extends FinalMethodDemo1 {
    @Override
    public void drink() {
        super.drink();
    }

//    public void eat(){
//
//    }



}

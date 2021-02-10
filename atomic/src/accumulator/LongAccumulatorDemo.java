package accumulator;

import java.util.concurrent.atomic.LongAccumulator;

/**
 * 演示LongAccumulator的用法
 *
 * @author 多宝
 * @since 2021/2/10 18:36
 */
public class LongAccumulatorDemo {

    public static void main(String[] args) {
        // 表达式x是初始值，y是后来的值，我们这个Accumulator的作用就是会把我们当前的值，作为初始值，
        // 然后去计算出下一个的值，比如说我们在这里初始值我们定为0，然后我们计算下一个值对不对
        LongAccumulator accumulator = new LongAccumulator((x, y) -> x + y, 0);

        // 怎么计算呢？
        accumulator.accumulate(1);
        // 打印出我们的到的值是1.
        // 这就意味着最开始我们的identity的值实际上是赋给了x的，然后当下一个进来的时候，
        // 也就是执行accumulator.accumulate(1)的时候，原来得到结果就变成了现在的y，那原来的结果是0。
        // 所以现在的y就是0，然后呢accumulator.accumulate(1);这里的x就是1，所以呢1+0就是输出结果是1
//        System.out.println(accumulator.getThenReset());

        // 如果我们在吧x写成2的话，他就会在原来1的基础上再去累加2
        // 这里有一个小问题，当我们去使用getThenReset()的时候，我们累加的值自动重置为初始值，
        // 也就是0，所以我们把上面打印结果的地方注释，再来输出结果。
        // 打印的结果就是3
        accumulator.accumulate(2);
        System.out.println(accumulator.getThenReset());
    }

}

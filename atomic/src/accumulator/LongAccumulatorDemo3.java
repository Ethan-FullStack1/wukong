package accumulator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

/**
 * 用LongAccumulator写的复杂一点
 *
 * @author 多宝
 * @since 2021/2/10 18:36
 */
public class LongAccumulatorDemo3 {

    public static void main(String[] args) {
        // 计算9的阶乘
        LongAccumulator accumulator = new LongAccumulator((x, y) -> x * y, 1);

        ExecutorService service = Executors.newFixedThreadPool(8);
        // 实现1 - 9每一次都去里面去传递一个计算，计算从1 + 到9
        IntStream.range(1, 10).forEach(i -> service.submit(() -> accumulator.accumulate(i)));

        // 先把线程给关掉
        service.shutdown();
        while (!service.isTerminated()) {

        }
        System.out.println(accumulator.getThenReset());
    }

}

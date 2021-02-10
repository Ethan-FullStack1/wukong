package EquivalentCode;

/**
 * 模拟CAS操作等价代码
 *
 * @author 多宝
 * @since 2021/2/10 20:57
 */
public class SimulatedCAS {

    private volatile int value;

    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectedValue) {
            value = newValue;
        }
        return oldValue;
    }

}

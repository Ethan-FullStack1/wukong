package lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 演示读写锁的公平与非公平
 *
 * @author 多宝
 * @since 2020/12/5 23:25
 */
public class NonfairBargeDemo {

    // 创建一个公平的读写锁
    private static final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(true);

}

package lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 演示公平和非公平的读写锁的策略
 *
 * @author 多宝
 * @since 2020/12/5 23:25
 */
public class NonfairBargeDemo {

    // 创建一个公平的读写锁
    private static final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(true);




}



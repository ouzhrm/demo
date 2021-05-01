import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-04-17 22:00
 **/
public class ReadWriteLockDemo {

    private static final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(false);
    //读锁
    private static final ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    //写锁
    private static final ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    /**
     * 锁降级线程任务
     */
    static class WriteToRead implements Runnable {
        @Override
        public void run() {
            writeLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获取到写锁,正在做写入逻辑");
                readLock.lock();
                System.out.println(Thread.currentThread().getName() + "获取到读锁,读取数据");
            } finally {
                readLock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放读锁");
                writeLock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放写锁");
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new WriteToRead()).start();
    }
}

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-04-15 21:05
 **/
public class HashMapTest {

    @Test
    public void test(){

        HashMap<Integer,String> map = new HashMap(1000);
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");

        map.put(4,"a");
        map.put(5,"b");
        map.put(6,"c");

        map.put(7,"a");
        map.put(8,"b");
        map.put(9,"c");

        map.put(10,"a");
        map.put(11,"b");
        map.put(12,"c");
        map.put(13,"c");
        map.get(2);
        map.remove(4);
        String a = "123";
        a.hashCode();
        int i = tableSizeFor(25);
        System.out.println(i);

        Hashtable<Integer,String> map2 = new Hashtable();
        map2.put(1,"123");
        "123".equals(123);
        Integer a22 = 123;
        a22.equals(123);

        ConcurrentHashMap<Integer,String> cmap = new ConcurrentHashMap<>();
        cmap.size();
        cmap.put(1,"123");
        cmap.get(1);

        AtomicReference<String> atomicReference = new AtomicReference<>();
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("123");
        linkedList.get(0);
        linkedList.remove(0);

        ArrayList<String> list = new ArrayList<>();
        list.add("123");
        list.get(0);
        list.remove(0);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(() -> {

        });
        executorService.shutdown();
        String a123 = "q1";
        a123.equals("123");

        CopyOnWriteArrayList arrayList = new CopyOnWriteArrayList();
        arrayList.add(1);
        //AbstractQueuedSynchronizer“
        
        Lock k  = new ReentrantLock();
        //ExecutorService executorService1 = Executors.newSingleThreadExecutor();





    }

    int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1<<30) ? 1<<30 : n + 1;
    }
}

import org.junit.Test;

import java.lang.ref.WeakReference;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-05-06 21:28
 **/
public class Test2 {

    @Test
    public void tes2t() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InterruptedException {
//        System.out.println('S' % 16);
//        Class<?> aClass = Class.forName("");
//        Object o = aClass.newInstance();
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"");


        StringBuffer buffer = new StringBuffer();
        buffer.append("1");

//        Thread a = new Thread();
//        a.interrupt();
//        a.wait();


        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for(int i=0; i < list.size(); i++){
            if(list.get(i) == 1)
                list.remove(i);
        }
        System.out.println(list);

        ReentrantLock lock = new ReentrantLock();
        lock.lock();

//        Iterator<Integer> it = list.iterator();
//        while(it.hasNext()){
//            Integer value = it.next();
//            if(value == 1){
//                list.remove(value);
//            }
//        }


    }

    @Test
    public void test(){
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.equals(threadLocal);
        threadLocal.set(123);
        threadLocal.remove();

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        AtomicInteger a = new AtomicInteger(1);
        String str = new String();
        str.equals("123");

        a.equals(123);
        //CountDownLatch countDownLatch = new CountDownLatch(4);
        List<Future> list = new ArrayList<>(4);
//        list.stream().collect(Collectors.groupingBy())
        for(int i = 1;i <= 4;i++){
            Future<?> submit = executorService.submit(() -> {
                System.out.println(a.getAndIncrement());
                //countDownLatch.countDown();
            });
            list.add(submit);
        }
        try {
            list.stream().forEach(future -> {
                try {
                    Object o = future.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
            //countDownLatch.await();
            System.out.println("teacher continue do!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();;
    }




}

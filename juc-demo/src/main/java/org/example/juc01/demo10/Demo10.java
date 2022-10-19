package org.example.juc01.demo10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo10 {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = test00();
//        ExecutorService executor = test01();
//        ExecutorService executor = test02();
//        ExecutorService executor = test03();

//        try {
//            for (int i = 0; i < 10; i++) {
//                int finalI = i;
//                executor.execute(() -> System.out.println(Thread.currentThread().getName() + "::" + "办理业务" + finalI));
//            }
//        } finally {
//            executor.shutdown();
//        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(1);
        boolean b = list.stream().noneMatch(x -> x.equals(1));
        System.out.println(b);

    }

    private static ThreadPoolExecutor test00() {
        return new ThreadPoolExecutor(
                2,
                7,
                2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }

    private static ExecutorService test01() {
        return Executors.newFixedThreadPool(5);
    }

    private static ExecutorService test02() {
        return Executors.newSingleThreadExecutor();
    }

    private static ExecutorService test03() {
        return Executors.newCachedThreadPool();
    }
}

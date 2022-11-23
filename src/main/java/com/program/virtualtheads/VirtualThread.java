package com.program.virtualtheads;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//public class VirtualThread {
//
//    public static void main(String[] args) throws InterruptedException{
//       // https://medium.com/javarevisited/how-to-use-java-19-virtual-threads-c16a32bad5f7
//
//        Runnable runnable = () -> System.out.println(Thread.currentThread().threadId());
//        Thread thread = Thread.ofVirtual().name("testVT").unstarted(runnable);
//        Thread testPT = Thread.ofPlatform().name("testPT").unstarted(runnable);
//        testPT.start();
//
//        Runnable runnable1 = () -> System.out.println(Thread.currentThread().threadId());
//        Thread thread1 = Thread.startVirtualThread(runnable);
//
//        Runnable runnable2 = () -> System.out.println(Thread.currentThread().isVirtual());
//        Thread thread2 = Thread.startVirtualThread(runnable);
//
//
//              Thread.sleep(10);
//
//        Thread thread3 = Thread.startVirtualThread(runnable);
//        thread3.join();
//
//        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
//            executor.submit(() -> System.out.println("hello"));
//        }
//        ScheduledExecutorService scheduledExecutorService =
//                Executors.newScheduledThreadPool(1);
//        scheduledExecutorService.scheduleAtFixedRate(() -> {
//            ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
//            ThreadInfo[] threadInfo = threadBean.dumpAllThreads(false, false);
//            System.out.println(threadInfo.length + " os thread");
//        }, 1, 1, TimeUnit.SECONDS);
//    }
//}

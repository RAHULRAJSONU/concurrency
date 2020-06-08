package io.github.rahulrajsonu.concurrency.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class FixedThreadPoolDemo {

  public static void main(String[] args) {
    ExecutorService es = Executors.newFixedThreadPool(10);
    for (int i = 0; i < 10; i++) {
      es.execute(new Task());
    }
    System.out.println("Thread Name: "+Thread.currentThread().getName());
  }

  static class Task implements Runnable {
    public void run(){
      System.out.println("Thread Name: "+Thread.currentThread().getName());
    }
  }
}

package io.github.rahulrajsonu.concurrency.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Will execute all task with single thread
 * if thread got killed, it will create again
 * Will help in executing sequential task
 * because it guarantees the sequential execution
 */
public class SingleThreadExecutor {

  public static void main(String[] args) {
    ExecutorService es = Executors.newSingleThreadExecutor();
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

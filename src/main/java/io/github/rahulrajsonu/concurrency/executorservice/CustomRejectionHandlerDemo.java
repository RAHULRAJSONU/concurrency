package io.github.rahulrajsonu.concurrency.executorservice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomRejectionHandlerDemo {

  public static void main(String[] args) {
    ExecutorService es =
        new ThreadPoolExecutor(
            10,
            100,
            120,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(300)
        );

  }
  static class CustomRejectionHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
      System.err.println("Task Rejected");
    }
  }
  static class Task implements Runnable {
    public void run() {
      System.out.println("Thread Name: " + Thread.currentThread().getName());
    }
  }
}

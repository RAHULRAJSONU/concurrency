package io.github.rahulrajsonu.concurrency.executorservice;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService es = Executors.newFixedThreadPool(10);
    Future<Integer> res = es.submit(new Task());
    System.out.println(res.get());
  }

  static class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
      Thread.sleep(100);
      return new Random().nextInt();
    }
  }
}

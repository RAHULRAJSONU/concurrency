package io.github.rahulrajsonu.concurrency.executorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {

  public static void main(String[] args) {
    ScheduledExecutorService es = Executors.newScheduledThreadPool(10);
    // Task to run after 10 second delay
    es.schedule(new Task(),10, TimeUnit.SECONDS);
    // Task to run repeatedly every 10 second
    es.scheduleAtFixedRate(new Task(),15,10,TimeUnit.SECONDS);
    // Task to run repeatedly 10 second after previous task completes
    es.scheduleWithFixedDelay(new Task(),15,10,TimeUnit.SECONDS);
    System.out.println("Thread Name: "+Thread.currentThread().getName());
  }

  static class Task implements Runnable {
    public void run(){
      System.out.println("Thread Name: "+Thread.currentThread().getName());
    }
  }
}

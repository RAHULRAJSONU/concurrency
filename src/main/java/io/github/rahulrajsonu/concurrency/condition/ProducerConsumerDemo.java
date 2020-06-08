package io.github.rahulrajsonu.concurrency.condition;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerDemo {
  private int count;
  private int maxCount;
  Queue<Integer> list;
  private Lock lock = new ReentrantLock();
  private Condition added = lock.newCondition();
  private Condition removed = lock.newCondition();

  public ProducerConsumerDemo(int max){
    this.maxCount = max;
    list = new LinkedList<>();
  }

  public void produce() throws InterruptedException {
    lock.lock();
    try {
      while (count==maxCount)
        removed.await();
      list.add(new Random().nextInt());
      added.signal();
    }finally {
      lock.unlock();
    }
  }

  public Integer consume() throws InterruptedException {
    lock.lock();
    try{
      while (count==0)
        added.await();
      Integer data = list.poll();
      return data;
    }finally {
      lock.unlock();
    }
  }
}

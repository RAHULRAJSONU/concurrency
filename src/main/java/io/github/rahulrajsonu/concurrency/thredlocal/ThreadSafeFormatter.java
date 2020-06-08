package io.github.rahulrajsonu.concurrency.thredlocal;

import java.text.SimpleDateFormat;

public class ThreadSafeFormatter {
  public static ThreadLocal<SimpleDateFormat> dateFormatter =
      ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd"));
}

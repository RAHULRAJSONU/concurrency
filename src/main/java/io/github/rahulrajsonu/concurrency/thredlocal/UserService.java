package io.github.rahulrajsonu.concurrency.thredlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserService {

  public static void main(String[] args) {

  }

  public String birthDate(int userId){
    Date birthDate = new Date();
    final SimpleDateFormat df = ThreadSafeFormatter.dateFormatter.get();
    return df.format(birthDate);
  }
}

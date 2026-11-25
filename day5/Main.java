import java.util.*;

public class Main {
    public static void main(String[] args) {
      Thread t1 = new Thread(() -> System.out.println("placing order"));
      Thread t2 = new Thread(() -> System.out.println("confirm order"));
      Thread t3 = new Thread(() -> System.out.println("ready to pick"));
      t1.getPriority();
      t2.getPriority();
      t3.getPriority();
      t1.start();
      t2.start();
      t3.start();
      t1.join();
        t2.join();
        t3.join();
      System.out.println("ready to eat");
    }
}

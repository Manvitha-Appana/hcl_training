
import java.util.concurrent.*;

class Main {
    public static void main(String[] args) throws Exception {

        ExecutorService es = Executors.newSingleThreadExecutor();

        Runnable r = () -> {
            int m1 = 80, m2 = 90, m3 = 85;
            int total = m1 + m2 + m3;

            System.out.println("Total Marks: " + total);
        };

        Future<?> f1 = es.submit(r);

        Callable<Double> c = () -> {
            int m1 = 80, m2 = 90, m3 = 85;
            int total = m1 + m2 + m3;

            double percentage = (total / 300.0) * 100;
            return percentage;
        };

        Future<Double> f2 = es.submit(c);

        System.out.println("Runnable Done: " + f1.isDone());
        System.out.println("Percentage: " + f2.get() + "%");
        System.out.println("Callable Done: " + f2.isDone());

        es.shutdown();
    }
}

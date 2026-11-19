import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        // Create a list of attendance percentages
        List<Integer> attendance = Arrays.asList(95, 45, 80, 30, 100);

        // Predicate to check attendance >= 75
        Predicate<Integer> eligible = a -> a >= 75;

        // Consumer to print eligible attendance
        Consumer<Integer> printEligible = a -> {
            if (eligible.test(a)) {
                System.out.println(a);
            }
        };

        // Process the list using forEach()
        attendance.forEach(printEligible);
    }
}

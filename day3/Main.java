import java.util.*;
import java.util.stream.*;

class Order {
    int id;
    String customer;
    String product;
    String category;
    double amount;
    String status;
    String city;

    Order(int id, String customer, String product, String category,
         double amount, String status, String city) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.category = category;
        this.amount = amount;
        this.status = status;
        this.city = city;
    }

    public String toString() {
        return product + "(" + amount + ")";
    }
}

public class Main {
    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
            new Order(101, "Asha", "Laptop", "Electronics", 50000, "Delivered", "Vijayawada"),
            new Order(102, "Rahul", "Phone", "Electronics", 20000, "Pending", "Hyderabad"),
            new Order(103, "Sneha", "Shoes", "Fashion", 3000, "Delivered", "Chennai"),
            new Order(104, "Kiran", "Watch", "Fashion", 5000, "Delivered", "Vijayawada"),
            new Order(105, "Priya", "Tablet", "Electronics", 15000, "Delivered", "Hyderabad")
        );

        // 1. Filter orders
        System.out.println("Filtered Orders:");
        orders.stream()
            .filter(o -> o.amount > 10000 && o.status.equals("Delivered"))
            .forEach(System.out::println);

        // 2. Sort by amount
        System.out.println("\nSorted Orders:");
        orders.stream()
            .sorted(Comparator.comparingDouble(o -> o.amount))
            .forEach(System.out::println);

        // 3. Highest and lowest amount
        double max = orders.stream().mapToDouble(o -> o.amount).max().orElse(0);
        double min = orders.stream().mapToDouble(o -> o.amount).min().orElse(0);

        System.out.println("\nHighest Amount: " + max);
        System.out.println("Lowest Amount: " + min);

        // 4. Total sales
        double total = orders.stream().mapToDouble(o -> o.amount).sum();
        System.out.println("Total Sales: " + total);

        // 5. Count orders
        long count = orders.stream().count();
        System.out.println("Order Count: " + count);

        // 6. Group by category
        System.out.println("\nGroup by Category:");
        orders.stream()
            .collect(Collectors.groupingBy(o -> o.category))
            .forEach((k, v) -> System.out.println(k + " : " + v));

        // 7. Group by city
        System.out.println("\nGroup by City:");
        orders.stream()
            .collect(Collectors.groupingBy(o -> o.city))
            .forEach((k, v) -> System.out.println(k + " : " + v));

        // 8. Average amount
        double avg = orders.stream().mapToDouble(o -> o.amount).average().orElse(0);
        System.out.println("\nAverage Amount: " + avg);
    }
}

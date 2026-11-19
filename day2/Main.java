@FunctionalInterface
interface Welcome {
    void display();
}

@FunctionalInterface
interface GST {
    double calculate(double price);
}

@FunctionalInterface
interface TotalBill {
    double calculate(double price, int quantity);
}

@FunctionalInterface
interface Discount {
    double calculate(double price);
}

@FunctionalInterface
interface FinalAmount {
    double calculate(double price);
}

public class Main {
    public static void main(String[] args) {

        // 1. Welcome message
        Welcome w = () ->
            System.out.println("Welcome to Shopping Application!");

        // 2. Calculate 18% GST
        GST g = price -> price * 0.18;

        // 3. Calculate total bill
        TotalBill t = (price, quantity) -> price * quantity;

        // 4. Calculate 10% discount
        Discount d = price -> price * 0.10;

        // 5. Final amount after discount
        FinalAmount f = price -> {
            double discount = price * 0.10;
            double finalPrice = price - discount;
            return finalPrice;
        };

        w.display();

        double price = 1000;
        int quantity = 2;

        System.out.println("Product Price: " + price);
        System.out.println("18% GST: " + g.calculate(price));
        System.out.println("Total Bill: " + t.calculate(price, quantity));
        System.out.println("10% Discount: " + d.calculate(price));
        System.out.println("Final Amount: " + f.calculate(price));
    }
}
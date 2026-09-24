import java.util.Scanner;

public class VendingMachine {

    static String[] products = {
        "Water",
        "Juice",
        "Chips",
        "Chocolate",
        "Biscuits",
        "Coffee"
    };

    static double[] prices = {
        20,
        40,
        30,
        50,
        25,
        35
    };

    static int[] stock = {
        5,
        5,
        5,
        5,
        5,
        5
    };

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==============================");
            System.out.println("     VENDING MACHINE");
            System.out.println("==============================");

            // Display products
            for (int i = 0; i < products.length; i++) {
                System.out.println(
                    (i + 1) + ". " + products[i] +
                    " - Rs." + prices[i] +
                    " (Stock: " + stock[i] + ")"
                );
            }

            System.out.println("0. Exit");

            // Product choice
            System.out.print("\nEnter product number: ");
            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("Thank you!");
                break;
            }

            // Check product choice
            if (choice < 1 || choice > products.length) {
                System.out.println("Invalid product number!");
                continue;
            }

            int index = choice - 1;

            // Check stock
            if (stock[index] == 0) {
                System.out.println("Product is out of stock!");
                continue;
            }

            // Quantity
            System.out.print("Enter number of items: ");
            int quantity = sc.nextInt();

            // Check quantity
            if (quantity <= 0) {
                System.out.println("Invalid quantity!");
                continue;
            }

            // Check available stock
            if (quantity > stock[index]) {
                System.out.println(
                    "Only " + stock[index] + " item(s) available!"
                );
                continue;
            }

            // Calculate total
            double total = prices[index] * quantity;

            System.out.println("\n------------------------------");
            System.out.println("Product  : " + products[index]);
            System.out.println("Quantity : " + quantity);
            System.out.println("Price    : Rs." + prices[index]);
            System.out.println("Total    : Rs." + total);
            System.out.println("------------------------------");

            // Payment
            System.out.print("Enter payment: Rs.");
            double payment = sc.nextDouble();

            if (payment < total) {
                System.out.println("Insufficient payment!");
                System.out.println(
                    "You need Rs." + (total - payment) + " more."
                );
                continue;
            }

            // Change
            double change = payment - total;

            // Reduce stock
            stock[index] = stock[index] - quantity;

            // Receipt
            System.out.println("\n==============================");
            System.out.println("          RECEIPT");
            System.out.println("==============================");
            System.out.println("Product  : " + products[index]);
            System.out.println("Quantity : " + quantity);
            System.out.println("Total    : Rs." + total);
            System.out.println("Paid     : Rs." + payment);
            System.out.println("Change   : Rs." + change);
            System.out.println("==============================");
            System.out.println("Please collect your product.");
            System.out.println("Thank you!");
        }

        sc.close();
    }
}


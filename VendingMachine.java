
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

        double grandTotal = 0;

        // Store selected quantity of each product
        int[] selectedQuantity = new int[products.length];

        System.out.println("\n==============================");
        System.out.println("       VENDING MACHINE");
        System.out.println("==============================");

        // Display products
        for (int i = 0; i < products.length; i++) {
            System.out.println(
                (i + 1) + ". " + products[i]
                + " - Rs." + prices[i]
                + " (Stock: " + stock[i] + ")"
            );
        }

        System.out.println("0. Finish Selection");

        // Select multiple products
        while (true) {

            System.out.print("\nEnter product number: ");
            int choice = sc.nextInt();

            // Finish selection
            if (choice == 0) {
                break;
            }

            // Check product number
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

            // Enter quantity
            System.out.print(
                "Enter quantity of " + products[index] + ": "
            );

            int quantity = sc.nextInt();

            // Check quantity
            if (quantity <= 0) {
                System.out.println("Invalid quantity!");
                continue;
            }

            // Check available stock
            if (selectedQuantity[index] + quantity > stock[index]) {
                System.out.println(
                    "Only " + stock[index] + " item(s) available!"
                );
                continue;
            }

            // Add selected quantity
            selectedQuantity[index] += quantity;

            System.out.println(
                quantity + " " + products[index]
                + "(s) added to your order."
            );
        }

        // Check if any item was selected
        boolean itemSelected = false;

        for (int quantity : selectedQuantity) {
            if (quantity > 0) {
                itemSelected = true;
                break;
            }
        }

        // No item selected
        if (!itemSelected) {

            System.out.println("\nNo items selected.");
            System.out.println("Thank you! Visit again!");

            sc.close();
            return;
        }

        // Order Summary
        System.out.println("\n==============================");
        System.out.println("       ORDER SUMMARY");
        System.out.println("==============================");

        for (int i = 0; i < products.length; i++) {

            if (selectedQuantity[i] > 0) {

                double itemTotal =
                    prices[i] * selectedQuantity[i];

                grandTotal += itemTotal;

                System.out.printf(
                    "%-12s x %-3d Rs.%.2f%n",
                    products[i],
                    selectedQuantity[i],
                    itemTotal
                );
            }
        }

        System.out.println("------------------------------");

        System.out.printf(
            "Grand Total : Rs.%.2f%n",
            grandTotal
        );

        System.out.println("==============================");

       
        // Reduce stock
        for (int i = 0; i < products.length; i++) {
            stock[i] -= selectedQuantity[i];
        }

        // Payment successful
        System.out.println("\n==============================");
        System.out.println("      PAYMENT SUCCESSFUL");
        System.out.println("==============================");

        // Dispensing
        System.out.println("\n==============================");
        System.out.println("       DISPENSING ITEMS");
        System.out.println("==============================");

        for (int i = 0; i < products.length; i++) {

            if (selectedQuantity[i] > 0) {

                System.out.println(
                    "\nDispensing "
                    + selectedQuantity[i]
                    + " x "
                    + products[i]
                    + "..."
                );

                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println(
                    products[i]
                    + " dispensed successfully!"
                );
            }
        }

        // Receipt
        System.out.println("\n==============================");
        System.out.println("          RECEIPT");
        System.out.println("==============================");

        for (int i = 0; i < products.length; i++) {

            if (selectedQuantity[i] > 0) {

                double itemTotal =
                    prices[i] * selectedQuantity[i];

                System.out.printf(
                    "%-12s x %-3d Rs.%.2f%n",
                    products[i],
                    selectedQuantity[i],
                    itemTotal
                );
            }
        }

        System.out.println("------------------------------");

        System.out.printf(
            "Total : Rs.%.2f%n",
            grandTotal
        );

        System.out.println("==============================");
        System.out.println("==============================");
        System.out.println("Transaction completed successfully!");
        System.out.println("==============================");
        System.out.println("Thank you! Visit again!");
        System.out.println("==============================");

       
        // Exit program
        sc.close();
    }
}


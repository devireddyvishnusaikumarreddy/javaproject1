import java.util.Scanner;

public class VendingMachine {

    // Product information - Module 3: Arrays
    static String[] products = {
        "Water",
        "Juice",
        "Chips",
        "Chocolate",
        "Biscuits",
        "Coffee"
    };

    static double[] prices = {
        20.0,
        40.0,
        30.0,
        50.0,
        25.0,
        35.0
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

    // Main method
    public static void main(String[] args) {

        int choice;

        System.out.println("======================================");
        System.out.println("     VENDING MACHINE SIMULATOR");
        System.out.println("======================================");

        // Module 2: while loop
        while (true) {

            displayMenu();

            System.out.println("\n0. Exit");
            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            // Module 2: if statement
            if (choice == 0) {
                System.out.println("\nThank you for using the vending machine!");
                break;
            }

            // Check valid choice
            if (choice < 1 || choice > products.length) {
                System.out.println("\nInvalid choice!");
                continue;
            }

            // Start transaction
            processPurchase(choice - 1);
        }

        sc.close();
    }

    // Method to display products
    // Module 3: Methods + for loop
    public static void displayMenu() {

        System.out.println("\n--------------------------------------");
        System.out.println("             PRODUCT MENU");
        System.out.println("--------------------------------------");

        for (int i = 0; i < products.length; i++) {

            System.out.printf(
                "%d. %-12s ₹%.2f   Stock: %d%n",
                i + 1,
                products[i],
                prices[i],
                stock[i]
            );
        }

        System.out.println("--------------------------------------");
    }

    // Method to process purchase
    public static void processPurchase(int productIndex) {

        System.out.println("\n--------------------------------------");
        System.out.println("Selected: " + products[productIndex]);
        System.out.printf("Price: ₹%.2f%n", prices[productIndex]);
        System.out.println("--------------------------------------");

        // Check stock
        if (stock[productIndex] <= 0) {

            System.out.println("Sorry! Product is out of stock.");
            return;
        }

        System.out.print("Enter payment amount: ₹");
        double payment = sc.nextDouble();

        // Check payment
        if (payment < prices[productIndex]) {

            double remaining = prices[productIndex] - payment;

            System.out.printf(
                "Insufficient payment! You need ₹%.2f more.%n",
                remaining
            );

            return;
        }

        // Calculate change
        double change = payment - prices[productIndex];

        // Reduce stock
        stock[productIndex]--;

        // Dispense product
        dispenseProduct(productIndex);

        // Display change
        calculateChange(change);

        // Print receipt
        printReceipt(productIndex, payment, change);

        System.out.println("--------------------------------------");
        System.out.println("Transaction completed successfully!");
        System.out.println("--------------------------------------");
    }

    // Method to dispense product
    public static void dispenseProduct(int productIndex) {

        System.out.println("\nDispensing...");
        System.out.println("Please collect your " +
                           products[productIndex] + ".");
    }

    // Method to calculate and display change
public static void calculateChange(double change) {

    System.out.printf("Change: ₹%.2f%n", change);

    int remaining = (int) change;

    // Calculate ₹100 notes
    int hundred = remaining / 100;
    remaining = remaining % 100;

    // Calculate ₹50 notes
    int fifty = remaining / 50;
    remaining = remaining % 50;

    // Calculate ₹20 notes
    int twenty = remaining / 20;
    remaining = remaining % 20;

    // Calculate ₹10 notes
    int ten = remaining / 10;
    remaining = remaining % 10;

    // Calculate ₹5 notes
    int five = remaining / 5;
    remaining = remaining % 5;

    System.out.println("\nChange Breakdown:");
    System.out.println("₹100 notes: " + hundred);
    System.out.println("₹50 notes : " + fifty);
    System.out.println("₹20 notes : " + twenty);
    System.out.println("₹10 notes : " + ten);
    System.out.println("₹5 notes  : " + five);

    if (remaining > 0) {
        System.out.println("Remaining amount: ₹" + remaining);
    }
}
    // Method to print receipt
    public static void printReceipt(
        int productIndex,
        double payment,
        double change
    ) {

        System.out.println("\n======================================");
        System.out.println("              RECEIPT");
        System.out.println("======================================");

        System.out.println("Product : " + products[productIndex]);

        System.out.printf(
            "Price   : ₹%.2f%n",
            prices[productIndex]
        );

        System.out.printf(
            "Paid    : ₹%.2f%n",
            payment
        );

        System.out.printf(
            "Change  : ₹%.2f%n",
            change
        );

        System.out.println("--------------------------------------");
        System.out.println("Thank you! Visit again.");
        System.out.println("======================================");
    }
}

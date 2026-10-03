import java.util.Scanner;

public class HouseholdDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter House Number (Integer): ");
        int houseNumber = scanner.nextInt();

        System.out.print("Enter Number of Family Members (Integer): ");
        int familyMembers = scanner.nextInt();

        System.out.print("Enter Water Consumed in Litres (Decimal): ");
        double waterConsumedLitres = scanner.nextDouble();

        System.out.print("Enter Water Usage Status (Single Character): ");
        char waterUsageStatus = scanner.next().charAt(0);

        System.out.println("\n--- Household Details ---");
        System.out.println("House Number: " + houseNumber);
        System.out.println("Number of Family Members: " + familyMembers);
        System.out.println("Water Consumed (litres): " + waterConsumedLitres);
        System.out.println("Water Usage Status: " + waterUsageStatus);

        scanner.close();
    }
}

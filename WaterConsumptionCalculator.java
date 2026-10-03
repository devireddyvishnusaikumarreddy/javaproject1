import java.util.Scanner;

public class WaterConsumptionCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter morning water usage (in litres): ");
        int morning = scanner.nextInt();

        System.out.print("Enter evening water usage (in litres): ");
        int evening = scanner.nextInt();

        int totalConsumption = calculateTotal(morning, evening);

        System.out.println("Total water consumption: " + totalConsumption + " litres");

        scanner.close();
    }

    public static int calculateTotal(int morningUsage, int eveningUsage) {
        return morningUsage + eveningUsage;
    }
}

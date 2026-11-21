import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Temperature Converter ===");
        System.out.println("Select the input temperature scale:");
        System.out.println("1. Celsius (°C)");
        System.out.println("2. Fahrenheit (°F)");
        System.out.println("3. Kelvin (K)");
        System.out.print("Enter your choice (1-3): ");

        int choice = scanner.nextInt();

        System.out.print("Enter the temperature value: ");
        double temp = scanner.nextDouble();

        System.out.println("\n--- Conversion Results ---");

        switch (choice) {
            case 1: // Celsius to Fahrenheit & Kelvin
                double cToF = (temp * 9.0 / 5.0) + 32;
                double cToK = temp + 273.15;
                System.out.printf("%.2f °C = %.2f °F%n", temp, cToF);
                System.out.printf("%.2f °C = %.2f K%n", temp, cToK);
                break;

            case 2: // Fahrenheit to Celsius & Kelvin
                double fToC = (temp - 32) * 5.0 / 9.0;
                double fToK = fToC + 273.15;
                System.out.printf("%.2f °F = %.2f °C%n", temp, fToC);
                System.out.printf("%.2f °F = %.2f K%n", temp, fToK);
                break;

            case 3: // Kelvin to Celsius & Fahrenheit
                if (temp < 0) {
                    System.out.println("Warning: Temperature cannot be below absolute zero (0 K).");
                } else {
                    double kToC = temp - 273.15;
                    double kToF = (kToC * 9.0 / 5.0) + 32;
                    System.out.printf("%.2f K = %.2f °C%n", temp, kToC);
                    System.out.printf("%.2f K = %.2f °F%n", temp, kToF);
                }
                break;

            default:
                System.out.println("Invalid choice! Please select 1, 2, or 3.");
        }

        scanner.close();
    }
}


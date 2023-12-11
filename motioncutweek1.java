import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Temperature Converter!");
        System.out.println("Enter the temperature value:");

        // Validate and get temperature value
        double temperature = getValidTemperature();

        // Get temperature unit (Celsius or Fahrenheit)
        String unit = getValidUnit();

        // Perform conversion based on user input
        double convertedTemperature = convertTemperature(temperature, unit);

        // Display the result
        System.out.println("Result: " + temperature + " " + unit + " is equal to " + convertedTemperature + " " + getOppositeUnit(unit));
    }

    private static double getValidTemperature() {
        Scanner scanner = new Scanner(System.in);
        double temperature;

        while (true) {
            try {
                temperature = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid temperature value:");
            }
        }

        return temperature;
    }

    private static String getValidUnit() {
        Scanner scanner = new Scanner(System.in);
        String unit;

        while (true) {
            System.out.println("Enter the temperature unit (C for Celsius, F for Fahrenheit):");
            unit = scanner.nextLine().toUpperCase();

            if (unit.equals("C") || unit.equals("F")) {
                break;
            } else {
                System.out.println("Invalid unit. Please enter either C or F.");
            }
        }

        return unit;
    }

    private static double convertTemperature(double temperature, String unit) {
        if (unit.equals("C")) {
            return (temperature * 9 / 5) + 32;
        } else {
            return (temperature - 32) * 5 / 9;
        }
    }

    private static String getOppositeUnit(String unit) {
        return unit.equals("C") ? "Fahrenheit" : "Celsius";
    }
}

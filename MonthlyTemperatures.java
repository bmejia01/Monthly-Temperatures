import java.util.Scanner;

public class MonthlyTemperatures {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        double[] temps = new double[12];

        System.out.println("Enter the average temperature for each month.");

        for (int i = 0; i < months.length; i++) {
            System.out.print(months[i] + ": ");
            while (!input.hasNextDouble()) {
                System.out.print("Please enter a number for " + months[i] + ": ");
                input.next();
            }
            temps[i] = input.nextDouble();
        }

        input.nextLine(); // consume leftover newline

        boolean running = true;

        while (running) {
            System.out.print("\nType a month name, 'year', or 'exit': ");
            String choice = input.nextLine().trim();

            if (choice.equalsIgnoreCase("exit")) {
                running = false;
            } else if (choice.equalsIgnoreCase("year")) {

                double total = 0;
                double highestTemp = temps[0];
                double lowestTemp = temps[0];
                String highestMonth = months[0];
                String lowestMonth = months[0];

                System.out.println("\nMonthly Temperatures:");
                for (int i = 0; i < months.length; i++) {
                    System.out.println(months[i] + ": " + temps[i]);
                    total += temps[i];

                    if (temps[i] > highestTemp) {
                        highestTemp = temps[i];
                        highestMonth = months[i];
                    }

                    if (temps[i] < lowestTemp) {
                        lowestTemp = temps[i];
                        lowestMonth = months[i];
                    }
                }

                double yearlyAverage = total / months.length;

                System.out.println("\nYearly Average: " + yearlyAverage);
                System.out.println("Highest Monthly Average: " + highestMonth + " (" + highestTemp + ")");
                System.out.println("Lowest Monthly Average: " + lowestMonth + " (" + lowestTemp + ")");

            } else {
                boolean found = false;

                for (int i = 0; i < months.length; i++) {
                    if (choice.equalsIgnoreCase(months[i])) {
                        System.out.println(months[i] + " average temperature: " + temps[i]);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Month not found. Example: March, October, or type 'year'.");
                }
            }
        }

        System.out.println("Program ended.");
        input.close();
    }
}
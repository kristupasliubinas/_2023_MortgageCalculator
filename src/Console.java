import java.util.Scanner;

public class Console {
    public static double readInput(String inputMessage, double min, double max) {
        double input;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(inputMessage);
            input = scanner.nextDouble();
            if (input >= min && input <= max)
                break;
            System.out.println("Enter a number between " + min + " and " + max + ".");
        }

        return input;
    }
}

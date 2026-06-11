
import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.print("Choose operation (1/2): ");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("Result: " + (a + b));
        } else if (choice == 2) {
            System.out.println("Result: " + (a - b));
        } else {
            System.out.println("Invalid choice!");
        }

        sc.close();
    }
}

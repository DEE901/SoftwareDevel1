// by Deegan
// for software class project

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        System.out.print("Enter a float: ");
        float decimal = scanner.nextFloat();

        scanner.nextline();

        System.out.print("Enter your full name (first and last): ");
        String fullName = scanner.nextLine();

        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts.length > 1 ? nameParts[1] : ""; 

        System.out.print("Enter a line of text: ");
        String line = scanner.nextLine();

        System.out.println("\n--- Output ---");
        System.out.println("Integer: " + number);
        System.out.println("Float: " + decimal);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Line: " + line);

        scanner.close();
    }
}
// by Deegan
// for software class project

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        greetUser(name);
        scanner.close();
    }

    public static void greetUser(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

//by Deegan Hansen
//for software class project
//student info

import java.io.BufferedReader;
import java.io.Filewriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentInfo {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name (first and last): ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter your year (9th, 10th, 11th, or 12th): ");
        String year = scanner.nextLine().trim();

        System.out.print("Enter your school name: ");
        String school = scanner.nextLine().trim();

        scanner.close();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("student.txt"))) {
            writer.write(name);
            writer.newLine();
            writer.write(year);
            writer.newLine();
            writer.write(school);
            writer.newLine();
            System.out.println("student.txt created with your information.");
        } catch (IOException e) {
            System.out.println("Error writing to student.txt: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


// Deegans code
// for software development class
//maybe to much code

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDataCollector {
    private static final String DATA_FILE = "user_data.txt";
    private static final int NUM_RECORDS = 5;
    
    static class PersonRecord {
        String name;
        String address;
        String pet;
        String car;
        String school;
        double age;
        
        PersonRecord(String name, String address, String pet, String car, String school, double age) {
            this.name = name;
            this.address = address;
            this.pet = pet;
            this.car = car;
            this.school = school;
            this.age = age;
        }
        
        @Override
        public String toString() {
            return name + "|" + address + "|" + pet + "|" + car + "|" + school + "|" + age;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<PersonRecord> records = new ArrayList<>();
        
        collectData(scanner, records);
        
        saveDataToFile(records);
        
        readAndDisplayData();
        
        scanner.close();
    }
    
    private static void collectData(Scanner scanner, List<PersonRecord> records) {
        System.out.println("=".repeat(60));
        System.out.println("USER DATA COLLECTION PROGRAM");
        System.out.println("=".repeat(60));
        System.out.println("\nPlease enter information for 5 different people.\n");
        
        for (int i = 1; i <= NUM_RECORDS; i++) {
            System.out.println("--- Person " + i + " ---");
            
            System.out.print("Enter name: ");
            String name = scanner.nextLine().trim();
            
            System.out.print("Enter address: ");
            String address = scanner.nextLine().trim();
            
            System.out.print("Enter pet: ");
            String pet = scanner.nextLine().trim();
            
            System.out.print("Enter car: ");
            String car = scanner.nextLine().trim();
            
            System.out.print("Enter school: ");
            String school = scanner.nextLine().trim();
        
            double age = getValidAge(scanner);
            
            PersonRecord record = new PersonRecord(name, address, pet, car, school, age);
            records.add(record);
            
            System.out.println("✓ Record saved for " + name);
            System.out.println();
        }
    }
    
    private static double getValidAge(Scanner scanner) {
        double age = -1;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("Enter age (numeric value): ");
            String input = scanner.nextLine().trim();
            
            try {
                age = Double.parseDouble(input);
                if (age >= 0 && age <= 150) {
                    validInput = true;
                } else {
                    System.out.println("⚠ Please enter an age between 0 and 150.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Invalid input! Please enter a valid numeric age.");
            }
        }
        
        return age;
    }
    
    private static void saveDataToFile(List<PersonRecord> records) {
        try (FileWriter fw = new FileWriter(DATA_FILE);
             BufferedWriter bw = new BufferedWriter(fw)) {
            
            for (PersonRecord record : records) {
                bw.write(record.toString());
                bw.newLine();
            }
            
            System.out.println("✓ Data saved to " + DATA_FILE);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    
    private static void readAndDisplayData() {
        List<PersonRecord> records = new ArrayList<>();
        double totalAge = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                PersonRecord record = parseRecord(line);
                if (record != null) {
                    records.add(record);
                    totalAge += record.age;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }
        
        displayRecords(records, totalAge);
    }
    
    private static PersonRecord parseRecord(String line) {
        String[] parts = line.split("\\|");
        if (parts.length == 6) {
            try {
                return new PersonRecord(
                    parts[0],
                    parts[1],
                    parts[2],
                    parts[3],
                    parts[4],
                    Double.parseDouble(parts[5])
                );
            } catch (NumberFormatException e) {
                System.err.println("Error parsing age from record: " + line);
            }
        }
        return null;
    }
    
    private static void displayRecords(List<PersonRecord> records, double totalAge) {
        System.out.println("\n\n");
        System.out.println("═".repeat(100));
        System.out.println("                        COLLECTED USER INFORMATION REPORT");
        System.out.println("═".repeat(100));
        
        System.out.printf("%-20s %-30s %-15s %-20s %-20s %-10s%n",
            "NAME", "ADDRESS", "PET", "CAR", "SCHOOL", "AGE");
        System.out.println("─".repeat(100));
        
        for (PersonRecord record : records) {
            System.out.printf("%-20s %-30s %-15s %-20s %-20s %-10.1f%n",
                truncate(record.name, 20),
                truncate(record.address, 30),
                truncate(record.pet, 15),
                truncate(record.car, 20),
                truncate(record.school, 20),
                record.age);
        }
        
        System.out.println("─".repeat(100));
        double averageAge = totalAge / records.size();
        System.out.printf("SUMMARY: Total of %d records | Average Age: %.2f years%n",
            records.size(), averageAge);
        System.out.println("═".repeat(100));
    }
    
    private static String truncate(String str, int length) {
        if (str.length() > length) {
            return str.substring(0, length - 3) + "...";
        }
        return str;
    }
}
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadStudent {
    public static void main(String[] args) {
        String fileName = "student.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String name = br.readLine();
            String year = br.readLine();
            String school = br.readLine();

            System.out.println("Reading from " + fileName + ":\n");

            if (name != null)  System.out.println(name);
            if (year != null)  System.out.println(year);
            if (school != null)  System.out.println(school);

            // If file had fewer than 3 lines, inform the user
            if (name == null && year == null && school == null) {
                System.out.println("(The file is empty)");
            }
        } catch (IOException e) {
            System.err.println("Error reading " + fileName + ": " + e.getMessage());
        }
    }
}
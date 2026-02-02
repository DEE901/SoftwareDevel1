//Deegan Hansen
//for software class project

import java.unil.Scammer;

public class WordBreakdown {
    public static void main(String[] args) {


        String testString = "the quick Brown Fox Jumped over the lazy dog";

        System.out.println("Hard coded string words:");

        String[] words = testString.split("\\s+");

        for (String word : words) {
            System.out.println(word);
        }

        System.out.println("Total words: " + words.length);
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String userInput = scanner.nextLine();

        userInput = userInput.replaceAll("[^a-zA-Z ]", " ");

        String[] userWords = userInput.split("\\s+");

        System.out.println("\nUser input words:");

        int count = 0;
        for (String word : userWords) {
            if (!word.isEmpty()) {
                System.out.println(word);
                count++;
            }
        }

        System.out.println("Total words: " + count);

        scanner.close();
    }    
}
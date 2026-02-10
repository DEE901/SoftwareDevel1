inport java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LetterFrequencyAnalyzer {

    static class LetterData {
        String letter;
        int frequency;
        float percentage;

        LetterData(String letter, int frequency, float percentage) {
            this.letter = letter;
            this.frequency = frequency;
            this.percentage = percentage;
        }
    }

    public static void main(String[] args) {
        String filePath = "letter_frequency (1).csv";
        List<LetterData> letterDataList = new ArrayList<>();

        try {
            BuferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] tokens = line.split(",");

                if (tokens.length >= 3) {
                    String letter = tokens[0].trim().replaceAll("\"", "");
                    int frequency = Integer.parseInt(tokens[1].trim());
                    float percentage = Float.parseFloat(tokens[2].trim());

                    letterDataList.add(new LetterData(letter, frequency, percentage));
                 }
            }

            reader.close();

            long totalFrequency = 0;
            float totalPercentage = 0.0f;

            for (LetterData data : letterDataList) {
                totalFrequency += data.frequency;
                totalPercentage += data.percentage;
            }

            double averageFrequency = (double) totalFrequency / letterDataList.size();

            System.out.println("Letter Frequency Analysis");
            System.out.println("===========================");

            for (LetterData data : letterDataList) {
                System.out.println(data.letter + "\t" + data.frequency + "\t" + data.percentage);
            }

            System.out.println("===========================");
            System.out.println("Total\t" + (long) averageFrequency + "\t" + totalPercentage);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
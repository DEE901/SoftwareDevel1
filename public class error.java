public class error {

    public static void main(String[] args) {

        try {
            int[] numbers = {10, 20, 30};
            System.out.println(numbers[2]);
            int value = numbers[3];
            System.out.println("Value: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\n------ Exception Caught ---");
            System.out.println("Error: " + e.getMessage());
            System.out.println("Please check the array indices.");
            System.out.println("Exiting program.");
        }

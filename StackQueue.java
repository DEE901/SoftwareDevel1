import java.util.*;

// Deegan hansen
// software class project
// stack and queue
public class StackQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== PART 1: Stack vs Queue ===");

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        System.out.println("Enter integers (-1 to stop):");

        while (true) {
            int input = scanner.nextInt();

            if (input == -1) {
                break;
            }

            queue.add(input);  
            stack.push(input); 
        }

        System.out.println("\nQueue output (FIFO):");
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }

        System.out.println("\nStack output (LIFO):");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println("\n\n=== PART 2: Real-World Simulation (Checkout Line) ===");

        Queue<String> checkoutLine = new LinkedList<>();

        checkoutLine.add("Alice");
        checkoutLine.add("Bob");
        checkoutLine.add("Charlie");
        checkoutLine.add("Diana");

        System.out.println("People entering the checkout line:");
        System.out.println("Alice, Bob, Charlie, Diana");

        System.out.println("\nProcessing checkout (FIFO order):");

        while (!checkoutLine.isEmpty()) {
            String person = checkoutLine.remove();
            System.out.println(person + " is being served...");
        }

        System.out.println("All customers have been served!");

        scanner.close();
    }
}
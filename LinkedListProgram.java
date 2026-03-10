import java.util.Scanner;

//Deegan Hansen
//software Development 2
//List Program
public class LinkedListProgram {
    private LinkedListNode head;
    private LinkedListNode tail;

    public LinkedListProgram() {
        this.head = null;
        this.tail = null;
    }

    public void addItem(String data) {
        LinkedListNode newNode = new LinkedListNode(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
    }

    public void printForwardToBackward() {
        System.out.println("\n=== Forward (Front to Back) ===");
        LinkedListNode current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public void printBackwardToFront() {
        System.out.println("\n=== Backward (Back to Front) ===");
        LinkedListNode current = tail;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getPrevious();
        }
    }

    public static void main(String[] args) {
        LinkedListProgram list = new LinkedListProgram();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Enter data items (e.g., '10 dogs', '4 cats')");
        System.out.println("Type 'quit' to stop adding items.\n");

        while (true) {
            System.out.print("Enter data: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            if (!input.isEmpty()) {
                list.addItem(input);
            }
        }

        list.printForwardToBackward();
        list.printBackwardToFront();

        scanner.close();
{
    private String data;
    private LinkedListNode next;
    private LinkedListNode previous;

    public LinkedListNode(String data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public LinkedListNode getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedListNode previous) {
        this.previous = previous;
    }
}
import java.util.Scanner;

// Node class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Linked List class
class LinkedList {
    Node head;

    // Insert at the end
    public void insert(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
        } else {
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println(data + " inserted.");
    }

    // Delete node by value
    public void delete(int data) {
        if(head == null) {
            System.out.println("List is empty.");
            return;
        }

        if(head.data == data) {
            head = head.next;
            System.out.println(data + " deleted.");
            return;
        }

        Node current = head;
        Node prev = null;

        while(current != null && current.data != data) {
            prev = current;
            current = current.next;
        }

        if(current == null) {
            System.out.println(data + " not found.");
            return;
        }

        prev.next = current.next;
        System.out.println(data + " deleted.");
    }

    // Display the list
    public void display() {
        if(head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        System.out.print("Linked List: ");
        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

// Main class
public class LinkedListImplementation {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n1. Insert\n2. Delete\n3. Display\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = sc.nextInt();
                    list.insert(value);
                    break;
                case 2:
                    System.out.print("Enter value to delete: ");
                    int delValue = sc.nextInt();
                    list.delete(delValue);
                    break;
                case 3:
                    list.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

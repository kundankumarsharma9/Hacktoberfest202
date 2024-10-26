class Node {
    int data;
    Node prev;
    Node next;

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    Node head;

    // Add a node at the end
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Add a node at the beginning
    public void addAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Delete a node with a specific value
    public void deleteNode(int key) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Node with data " + key + " not found.");
            return;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }

    // Display the list in forward direction
    public void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Display the list in reverse direction
    public void displayReverse() {
        Node temp = head;
        if (temp == null) return;
        
        // Go to last node
        while (temp.next != null) {
            temp = temp.next;
        }
        // Traverse backward
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        
        // Adding nodes
        dll.addNode(10);
        dll.addNode(20);
        dll.addNode(30);
        
        System.out.println("List in forward direction:");
        dll.displayForward();

        System.out.println("List in reverse direction:");
        dll.displayReverse();

        // Adding node at the beginning
        dll.addAtBeginning(5);
        System.out.println("After adding at the beginning:");
        dll.displayForward();

        // Deleting a node
        dll.deleteNode(20);
        System.out.println("After deleting 20:");
        dll.displayForward();
    }
}

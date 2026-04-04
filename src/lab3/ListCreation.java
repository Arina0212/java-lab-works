package lab3;

class Node2 {
    int value;
    Node2 next;

    Node2(int value, Node2 next) {
        this.value = value;
        this.next = next;
    }
}

public class ListCreation {
    public static void printList(Node2 head) {
        Node2 current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node2 headFromHead = null;
        for (int i = 5; i >= 1; i--) {
            headFromHead = new Node2(i, headFromHead);
        }
        printList(headFromHead);

        Node2 headFromTail = new Node2(1, null);
        Node2 tail = headFromTail;
        for (int i = 2; i <= 5; i++) {
            tail.next = new Node2(i, null);
            tail = tail.next;
        }
        printList(headFromTail);

    }
}

package lab3;

class Node {
    int value;
    Node next;
    Node(int val, Node nxt) { value = val; next = nxt; }
}

public class SimpleList {
    public static void main(String[] args) {
        Node head = new Node(1, null);
        head = new Node(2, head);
        head = new Node(3, head);
        Node ref = head;
        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
    }
}
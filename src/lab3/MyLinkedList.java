package lab3;

public class MyLinkedList {
    private Node head;

    public void createHead(int... values) {
        head = null;
        for (int i = values.length - 1; i >= 0; i--)
            head = new Node(values[i], head);
    }

    public void createTail(int... values) {
        head = null;
        if (values.length == 0) return;
        head = new Node(values[0], null);
        Node tail = head;
        for (int i = 1; i < values.length; i++) {
            tail.next = new Node(values[i], null);
            tail = tail.next;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node ref = head;
        while (ref != null) {
            sb.append(ref.value).append(" ");
            ref = ref.next;
        }
        return sb.toString().trim();
    }

    public void addFirst(int val) {
        head = new Node(val, head);
    }

    public void addLast(int val) {
        if (head == null) head = new Node(val, null);
        else {
            Node ref = head;
            while (ref.next != null) ref = ref.next;
            ref.next = new Node(val, null);
        }
    }

    public void insert(int pos, int val) {
        if (pos == 0) { addFirst(val); return; }
        Node ref = head;
        for (int i = 0; i < pos - 1 && ref != null; i++) ref = ref.next;
        if (ref == null) throw new IndexOutOfBoundsException();
        ref.next = new Node(val, ref.next);
    }

    public void removeFirst() {
        if (head != null) head = head.next;
    }

    public void removeLast() {
        if (head == null) return;
        if (head.next == null) { head = null; return; }
        Node ref = head;
        while (ref.next.next != null) ref = ref.next;
        ref.next = null;
    }

    public void remove(int pos) {
        if (pos == 0) { removeFirst(); return; }
        Node ref = head;
        for (int i = 0; i < pos - 1 && ref != null; i++) ref = ref.next;
        if (ref == null || ref.next == null) throw new IndexOutOfBoundsException();
        ref.next = ref.next.next;
    }

    public void createHeadRec(int... values) {
        head = createHeadRecHelper(values, values.length - 1);
    }
    private Node createHeadRecHelper(int[] values, int idx) {
        if (idx < 0) return null;
        return new Node(values[idx], createHeadRecHelper(values, idx - 1));
    }

    public void createTailRec(int... values) {
        head = createTailRecHelper(values, 0);
    }
    private Node createTailRecHelper(int[] values, int idx) {
        if (idx >= values.length) return null;
        return new Node(values[idx], createTailRecHelper(values, idx + 1));
    }

    public String toStringRec() {
        return toStringRecHelper(head).trim();
    }
    private String toStringRecHelper(Node node) {
        if (node == null) return "";
        return node.value + " " + toStringRecHelper(node.next);
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.createHead(1,2,3);
        System.out.println(list.toString());
        list.addFirst(0);
        list.addLast(4);
        System.out.println(list.toString());
        list.insert(2, 99);
        System.out.println(list.toString());
        list.remove(2);
        list.removeFirst();
        list.removeLast();
        System.out.println(list.toString());
        list.createTailRec(5,6,7);
        System.out.println(list.toStringRec());
    }
}

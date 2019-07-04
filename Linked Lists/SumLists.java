class SumLists {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static Node root;

    static int getNumber(Node head) {
        int result = 0;
        if (head == null) {
            return 0;
        }
        result = head.data + 10 * getNumber(head.next);
        return result;
    }

    static Node getListReverse(Node node, int number) {
        if (number <= 0) {
            return null;
        }
        node = new Node(number % 10);
        node.next = getListReverse(node.next, number / 10);
        return node;
    }

    static Node getListForward(Node node, int number) {
        node = getListReverse(node, number);
        Node prev = node;
        Node next = node.next;
        node.next = null;
        while (next != null) {
            Node temp = next.next;
            next.next = prev;
            prev = next;
            next = temp;
        }
        return prev;
    }

    public static void traverse(Node head) {
        if (head == null) {
            System.out.println("No nodes in the list");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node number_1 = null, number_2 = null;
        root = null;
        {
            number_1 = new Node(5);
            Node temp = new Node(1);
            number_1.next = temp;
            temp = new Node(6);
            number_1.next.next = temp;
        }
        {
            number_2 = new Node(5);
            Node temp = new Node(9);
            number_2.next = temp;
            temp = new Node(2);
            number_2.next.next = temp;
        }
        System.out.println((getNumber(number_2) + getNumber(number_1)));
        Node result = null;
        result = getListReverse(result, (getNumber(number_2) + getNumber(number_1)));
        traverse(result);
        Node result_1 = null;
        result_1 = getListForward(result_1, (getNumber(number_2) + getNumber(number_1)));
        traverse(result_1);
    }

}
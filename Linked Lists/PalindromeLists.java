class PalindromeLists {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
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

    public static int getLength(Node node) {
        if (node == null) {
            return 0;
        }
        int result = 0;
        while (node != null) {
            result++;
            node = node.next;
        }
        return result;
    }

    public static Node getReverse(Node node, Node later) {
        if (node == null) {
            return null;
        }
        Node newNode = new Node(node.data);
        Node temp = node.next;
        Node result = newNode;
        while (temp != null) {
            newNode = new Node(temp.data);
            newNode.next = result;
            // traverse(newNode);
            result = newNode;
            temp = temp.next;
        }
        return result;

    }

    public static boolean checkPalindrome(Node node) {
        int length = getLength(node);
        Node rev = getReverse(node, null);
        traverse(node);
        traverse(rev);
        int i = 0;
        for (i = 0; i < length / 2 + 1; i++) {
            if (node.data == rev.data) {
                node = node.next;
                rev = rev.next;
                continue;
            }
            break;
        }
        if (i == (length / 2) + 1) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        Node root = null;
        root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(3);
        root.next.next.next.next.next = new Node(2);
        root.next.next.next.next.next.next = new Node(1);
        System.out.println(checkPalindrome(root));
    }
}
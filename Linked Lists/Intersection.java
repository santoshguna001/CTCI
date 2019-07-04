class Intersection {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
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

    public static Node getIntersection(Node node1, Node node2) {

        Node tail1 = node1;
        Node tail2 = node2;
        while (tail1.next != null) {
            tail1 = tail1.next;
        }
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        if (tail1 != tail2) {
            return null;
        }
        int length1 = getLength(node1);
        int length2 = getLength(node2);
        Node greater = (length1 > length2) ? node1 : node2;
        Node smaller = (length1 < length2) ? node1 : node2;
        int count = 0;
        int difference = getLength(greater) - getLength(smaller);
        while (count < difference) {
            greater = greater.next;
            count++;
        }
        while (true) {
            if (greater == smaller) {
                System.out.println("Intersection at node with value " + greater.data);
                break;
            }
            greater = greater.next;
            smaller = smaller.next;
        }
        return greater;
    }

    public static void main(String[] args) {
        Node head_1 = new Node(4);
        head_1.next = new Node(5);
        head_1.next.next = new Node(6);
        head_1.next.next.next = new Node(7);
        head_1.next.next.next.next = new Node(8);
        head_1.next.next.next.next.next = new Node(9);
        head_1.next.next.next.next.next.next = new Node(10);

        Node head_2 = new Node(6);
        head_2.next = new Node(7);
        head_2.next.next = head_1.next.next.next.next;
        // Intersection at node with value 8

        traverse(head_1);
        traverse(head_2);

        if (getIntersection(head_1, head_2) == null) {
            System.out.println("No intersection");
        }
    }
}
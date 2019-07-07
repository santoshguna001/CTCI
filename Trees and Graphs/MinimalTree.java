/**
 * Given a sorted (increasing order) array with unique integer elements, write
 * an algo­ rithm to create a binary search tree with minimal height.
 */
class MinimalTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static Node getBST(int[] array) {
        if (array.length == 0) {
            return null;
        }

        int length = array.length;
        Node head = new Node(array[length / 2], null, null);

        int[] array_left = new int[length / 2], array_right = new int[length - length / 2 - 1];
        for (int i = 0, j = 0; i < length; i++) {
            if (i < length / 2) {
                array_left[j++] = array[i];
                continue;
            }
            if (i == length / 2) {
                j = 0;
                continue;
            }
            array_right[j++] = array[i];
        }
        head.left = getBST(array_left);
        head.right = getBST(array_right);
        return head;
    }

    static Node getBSTEfficient(int[] array, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        Node head = new Node(array[mid], null, null);
        head.left = getBSTEfficient(array, start, mid - 1);
        head.right = getBSTEfficient(array, mid + 1, end);
        return head;
    }

    public static void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        Node bst = getBST(array);
        inOrderTraversal(bst);
        System.out.println();
        inOrderTraversal(getBSTEfficient(array, 0, array.length - 1));
    }
}
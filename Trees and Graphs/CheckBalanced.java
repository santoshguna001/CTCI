/**
 * Implement a function to check if a binary tree is balanced. For the purposes
 * of this question, a balanced tree is defied to be a tree such that the
 * heights of the two subtrees of any node never differ by more than one.
 */
class CheckBalanced {
    static class Node {
        int data;
        Node left, right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static int getHeight(Node node, int height) {
        if (node == null) {
            return height;
        }
        int leftHeight = getHeight(node.left, height + 1);
        int rightHeight = getHeight(node.right, height + 1);
        return Math.max(leftHeight, rightHeight);
    }

    public static boolean isBalanced(Node node) {
        int difference = getHeight(node.left, 0) - getHeight(node.right, 0);
        if (difference <= 1 && difference >= -1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        /*
         * Node head = new Node(10, null, null); head.left = new Node(20, null, null);
         * head.right = new Node(30, null, null); head.left.left = new Node(40, null,
         * null); head.left.right = new Node(50, null, null); head.right.left = new
         * Node(60, null, null); head.right.right = new Node(70, null, null);
         * head.left.right.left = new Node(80, null, null); head.right.right.left = new
         * Node(90, null, null); head.right.right.left.left = new Node(100, null, null);
         */
        System.out.println(isBalanced(head));
    }
}
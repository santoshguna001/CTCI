import java.util.ArrayList;

class PathsWithSum {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void inOrderSums(Node node, int sum) {
        if (node == null) {
            return;
        }
        inOrderSums(node.left, sum);
        getPathsWithSum(node, sum, null);
        inOrderSums(node.right, sum);
    }

    static ArrayList<Node> list = new ArrayList<Node>();
    static int found = 0;

    static void getPathsWithSum(Node node, int sum, Integer sumSoFar) {
        if (node == null) {
            return;
        }
        if (node.data == sum) {
            if (!list.contains(node)) {
                found++;
                list.add(node);
            }
        }
        if (sumSoFar != null) {
            if (node.data + sumSoFar == sum) {
                found++;
            }
            getPathsWithSum(node.left, sum, sumSoFar + node.data);
            getPathsWithSum(node.right, sum, sumSoFar + node.data);
            return;
        }
        getPathsWithSum(node.left, sum, node.data);
        getPathsWithSum(node.right, sum, node.data);
    }

    public static void main(String[] args) {
        Node tree2 = new Node(1, new Node(-1, new Node(1), new Node(-1)), new Node(-1, new Node(1), new Node(-1)));
        Node tree3 = new Node(1, new Node(1, new Node(1), new Node(1)), new Node(1, new Node(1), new Node(1)));
        Node tree1 = new Node(1, new Node(2), new Node(3));
        int sum = 0;
        inOrderSums(tree2, sum);
        System.out.println(found + " paths");
    }
}
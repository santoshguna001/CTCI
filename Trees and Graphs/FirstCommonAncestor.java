class FirstCommonAncestor {
    static class Node {
        int data;
        Node left, right;

        Node(int data, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    public static boolean hasChild(Node root, Node node) {
        if (root == null || node == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        return hasChild(root.left, node) || hasChild(root.right, node);
    }

    public static Node findFCA(Node root, Node node1, Node node2) {
        if (node1 == null || node2 == null || root == null) {
            return null;
        }
        if (hasChild(node1, node2)) {
            return node1;
        }
        if (hasChild(node2, node1)) {
            return node2;
        }
        if (!hasChild(root, node1) && !hasChild(root, node2)) {
            return null;
        }
        if (hasChild(root.left, node1) && hasChild(root.left, node2)) {
            return findFCA(root.left, node1, node2);
        }
        if (hasChild(root.right, node1) && hasChild(root.right, node2)) {
            return findFCA(root.right, node1, node2);
        }
        return root;
    }

    public static void main(String[] args) {
        Node head = new Node(1, null, null);
        head.left = new Node(2, null, null);
        head.right = new Node(3, null, null);
        head.left.right = new Node(4, null, null);
        head.left.left = new Node(5, null, null);
        head.right.left = new Node(6, null, null);
        head.right.right = new Node(7, null, null);
        Node temp = findFCA(head, head.right.right, head.right.left);
        if (temp != null) {
            System.out.println(temp.data);
            return;
        }
        System.out.println("null");
    }
}
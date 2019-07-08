/**
 * Tl and T2 are two very large binary trees, with Tl much bigger than T2.
 * Create an algorithm to determine if T2 is a subtree of Tl. A tree T2 is a
 * subtree of Tl if there exists a node n in Tl such that the subtree of n is
 * identical to T2. That is, if you cut off the tree at node n, the two trees
 * would be identical.
 */
class CheckSubTree {
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

    static void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    static boolean areTreesSame(Node tree1, Node tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == tree2) {
            return areTreesSame(tree1.left, tree2.left) && areTreesSame(tree1.right, tree2.right);
        }
        return false;
    }

    static boolean checkSubTree(Node tree1, Node tree2, int height1, int height2) {
        if (height1 < height2) {
            return false;
        } else if (height1 > height2) {
            return checkSubTree(tree1.left, tree2, height1 - 1, height2)
                    || checkSubTree(tree1.right, tree2, height1 - 1, height2);
        } else {
            return areTreesSame(tree1, tree2);
        }

    }

    static int getHeight(Node node, int height) {
        if (node == null) {
            return height;
        }
        int rightHeight = getHeight(node.right, height + 1);
        int lefttHeight = getHeight(node.left, height + 1);
        return Math.max(lefttHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node tree2 = new Node(1, new Node(2, new Node(3), new Node(4)), new Node(5, new Node(6), new Node(7)));
        Node tree1 = new Node(10, new Node(20), tree2);
        System.out.println(checkSubTree(tree1, tree2, getHeight(tree1, 0), getHeight(tree2, 0)));
        System.out.println(checkSubTree(tree2, tree1, getHeight(tree2, 0), getHeight(tree1, 0)));
    }
}
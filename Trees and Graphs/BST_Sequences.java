
/**
 * A binary search tree was created by traversing through an array from left to
 * right and inserting each element. Given a binary search tree with distinct
 * elements, print all possible arrays that could have led to this tree. EXAMPLE
 * Input: Output: {2, 1, 3}, {2, 3, 1}
 */
import java.util.ArrayList;

class BST_Sequences {
    static class Node {
        int data;
        int level = 0;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void getSequence(Node node) {
        System.out.println(node.data + " " + node.level);
        ArrayList<Node> child = getChildren(node, 0);
        child.forEach(S -> System.out.println(S.data + " " + S.level));
        boolean[] array = new boolean[child.size()];
        StringBuilder source = new StringBuilder();
        source.append(Integer.toString(node.data).toString());
        System.out.println();
        getPermuations(child, child.get(child.size() - 1).level, array, source, 1);

    }

    public static boolean getPermuations(ArrayList<Node> list, int level, boolean[] array, StringBuilder source,
            int target_level) {

        if (source.length() == array.length + 1) {
            System.out.println(source);
            return true;
        }
        for (int j = 0; j < list.size(); j++) {
            if (array[j]) {
                continue;
            }
            if (list.get(j).level == target_level) {
                array[j] = true;
                source.append(Integer.toString(list.get(j).data).toString());
                if (!getPermuations(list, level, array, source, target_level)) {
                    getPermuations(list, level, array, source, target_level + 1);
                }

                array[j] = false;
                source.setLength(source.length() - 1);
            }
        }
        return false;
    }

    public static ArrayList<Node> getChildren(Node node, int count) {
        if (node == null) {
            return null;
        }
        ArrayList<Node> children = new ArrayList<Node>();
        if (node.left != null) {
            node.left.level = count + 1;
            children.add(node.left);
        }
        if (node.right != null) {
            node.right.level = count + 1;
            children.add(node.right);
        }
        ArrayList<Node> temp = getChildren(node.left, count + 1);
        if (temp != null) {
            children.addAll(temp);
        }
        temp = getChildren(node.right, count + 1);
        if (temp != null) {
            children.addAll(temp);
        }
        return children;
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
        Node node = new Node(2, new Node(1), new Node(5, new Node(3), new Node(4)));
        Node head = new Node(4, new Node(2, new Node(1), new Node(3)),
                new Node(6, new Node(5), new Node(7, null, new Node(8))));
        getSequence(node);
        inOrderTraversal(node);
    }
}
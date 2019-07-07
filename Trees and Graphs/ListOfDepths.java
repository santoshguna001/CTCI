import java.util.LinkedList;

/**
 * Given a binary tree, design an algorithm which creates a linked list of all
 * the nodes at each depth (e.g., if you have a tree with depth D, you'll have D
 * linked lists).
 */
class ListofDepths {
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

    static LinkedList<Node>[] createList(LinkedList<Node>[] lists, Node node, int height) {
        if (node == null) {
            return null;
        }
        LinkedList<Node> list = lists[height];
        list.add(node);
        if (node.left != null) {
            lists = createList(lists, node.left, height + 1);
        }
        if (node.right != null) {
            lists = createList(lists, node.right, height + 1);
        }
        return lists;
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
        LinkedList<Node>[] lists = new LinkedList[findHeight(head, 0)];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedList<Node>();
        }
        lists = createList(lists, head, 0);
        for (int i = 0; i < lists.length; i++) {
            System.out.println("Node with depth " + i + ":");
            LinkedList<Node> temp = lists[i];
            temp.forEach(S -> System.out.println(S.data));
        }
    }
}
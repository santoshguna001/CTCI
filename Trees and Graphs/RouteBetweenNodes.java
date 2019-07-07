import java.util.Queue;
import java.util.LinkedList;

class RouteBetweenNodes {
    static Node[] list = new Node[20];
    static int numberNodes = 0;

    static class Node {
        Node[] nodes = new Node[20];
        int size = 0;
        int[] values = new int[20];
        int id;

        Node(int id) {
            this.id = id;
        }

        public void addNode(int value, Node node) {
            nodes[size] = node;
            list[numberNodes++] = node;
            values[size++] = value;
        }

    }

    public static Node getNode(int id) {
        for (int i = 0; i < numberNodes; i++) {
            if (list[i].id == id) {
                return list[i];
            }
        }
        return null;
    }

    public static boolean checkRouteDFS(Node end, Node start) {
        if (start == end) {
            return true;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            for (int i = 0; i < temp.size; i++) {
                if (temp.nodes[i] == end) {
                    System.out.print(temp.id + "-->");
                    return true;
                }
                queue.add(temp.nodes[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        list[numberNodes++] = node;
        node.addNode(1, new Node(2));
        node.addNode(1, new Node(4));
        node = getNode(2);
        node.addNode(1, new Node(3));
        if (checkRouteDFS(getNode(3), getNode(1))) {
            System.out.println(getNode(3).id);
        } else {
            System.out.println(false);
        }
    }
}
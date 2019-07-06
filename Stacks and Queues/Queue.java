
/** Implement a MyQueue class which implements a queue using two stacks. */
import java.util.Stack;

class Queue {
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void enqueue(int value) {
        stack1.push(value);
        stack2.insertElementAt(value, 0);
    }

    public static void dequeue() {
        System.out.println(stack2.pop());
        stack1.removeElementAt(0);
    }

    public static void main(String args[]) {
        enqueue(10);
        enqueue(1);
        enqueue(3);
        enqueue(4);
        dequeue();
        dequeue();
        dequeue();
        dequeue();
    }
}
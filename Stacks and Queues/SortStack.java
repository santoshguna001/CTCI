
/**Write a program to sort a stack such that the smallest items are on the top. You can use
an additional temporary stack, but you may not copy the elements into any other data structure
(such as an array). */
import java.util.Stack;

class SortStack {
    public static Stack<Integer> maxifyStack(Stack<Integer> maxStack, Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return maxStack;
        }
        while (true) {
            int data = stack.pop();
            if (maxStack.isEmpty()) {
                maxStack.push(data);
            } else {
                while (true) {
                    if (maxStack.peek() > data) {
                        stack.push(maxStack.pop());
                        continue;
                    }
                    break;
                }
                maxStack.push(data);
            }
            if (stack.isEmpty()) {
                break;
            }
        }
        return maxStack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(11);
        stack.push(4);
        stack.push(7);
        stack.push(2);
        stack.forEach(S -> System.out.println(S));

        Stack<Integer> maxStack = new Stack<Integer>();
        maxStack = maxifyStack(maxStack, stack);
        stack.removeAllElements();
        while (!maxStack.isEmpty()) {
            stack.push(maxStack.pop());
        }
        System.out.println(" " + stack.size() + " " + maxStack.size());
        stack.forEach(S -> System.out.println(S));
    }
}
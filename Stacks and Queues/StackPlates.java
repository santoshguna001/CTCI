
/*Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
threhold. Implement a data structure SetOfStacks that mimics this. SetO-ftacks should be
composed of several stacks and should create a new stack once the previous one exceeds capacity.
SetOfStacks.push() and SetOfStacks. pop() should behave identically to a single stack
(that is, pop() should return the same values as it would if there werejust a single stack).
FOLLOW UP
ImplementafunctionpopAt ( int index) which performs apopoperationon aspecificsub-stack. */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

class StackPlates {
    static int threshold;

    static ArrayList<Stack<Integer>> stacks;
    static int current = 0;

    StackPlates(int threshold) {
        this.threshold = threshold;
        stacks = new ArrayList<Stack<Integer>>();
    }

    public static void push(int data) {

        int size = stacks.size();
        if (size != 0) {
            Stack stack = stacks.get(stacks.size() - 1);
            if (stack.size() != threshold) {
                stack.push(data);
                return;
            }
        }
        System.out.println("New stack created");
        Stack<Integer> newStack = new Stack<Integer>();
        newStack.add(data);
        stacks.add(newStack);
    }

    public static void pop() {

        int size = stacks.size();
        if (size != 0) {
            Stack stack = stacks.get(stacks.size() - 1);
            System.out.println(stack.pop());
            if (stack.size() == 0) {
                stacks.remove(stacks.size() - 1);
                return;
            }
            return;
        }
        System.out.println("No elements");
    }

    public static void popAt(int index) {

        int stackNumber = (int) Math.ceil(index / (threshold * 1.0));
        index %= threshold;
        Stack<Integer> stack = stacks.get(stackNumber - 1);
        Stack<Integer> stack_temp = null;
        stack.removeElementAt(index - 1);
        while (true) {
            if (stacks.size() > stackNumber) {
                stack_temp = stacks.get(stackNumber);
                for (int i = index; i < threshold; i++) {
                    int value = stack_temp.firstElement();
                    stack_temp.removeElementAt(0);
                    stack.push(value);
                }
                stack = stack_temp;
                stackNumber++;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        StackPlates sPlates = new StackPlates(3);
        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        push(6);
        push(7);
        push(8);
        push(9);
        push(10);
        push(11);

        popAt(5);

        int count = 1;
        for (Stack s : stacks) {
            if (s.size() == 0) {
                break;
            }
            System.out.println("Stack " + count++);
            s.forEach(S -> System.out.println(S));
        }
    }

}
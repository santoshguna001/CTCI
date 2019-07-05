import java.util.Scanner;

//Fixed Stack size and 3 stacks in one array
class ThreeIn1 {
    static int size, size1, size2, size3;
    static int array1size, array2size, array3size;
    public static int[] array;

    ThreeIn1(int size) {
        this.size = size;
        array1size = 0;
        array2size = 0;
        array3size = 0;
        size1 = size / 3;
        size2 = size1;
        size3 = size - (size1 << 1);
        array = new int[size];
        System.out.println(size + " " + size1 + " " + size2 + " " + size3);
    }

    public static void insertData(int stackNumber, int data) {
        if (stackNumber == 1) {
            if (array1size == size1) {
                System.out.println("Stack Overflow");
                return;
            }
            array[array1size++] = data;
            return;
        }
        if (stackNumber == 2) {
            if (array2size == size2) {
                System.out.println("Stack Overflow");
                return;
            }
            array[size1 + array2size++] = data;
            return;
        }
        if (stackNumber == 3) {
            if (array3size == size2) {
                System.out.println("Stack Overflow");
                return;
            }
            array[size1 + size2 + array2size++] = data;
            return;
        }
    }

    public static void displayData(int stackNumber) {
        if (stackNumber == 1) {
            if (array1size == 0) {
                System.out.println("Stack is empty");
                return;
            }
            for (int i = 0; i < array1size; i++) {
                System.out.println(array[i]);
            }
            return;
        }
        if (stackNumber == 2) {
            if (array2size == 0) {
                System.out.println("Stack is empty");
                return;
            }
            for (int i = size1; i < array2size; i++) {
                System.out.println(array[i]);
            }
            return;
        }
        if (stackNumber == 3) {
            if (array3size == 0) {
                System.out.println("Stack is empty");
                return;
            }
            for (int i = size1 + size2; i < array3size; i++) {
                System.out.println(array[i]);
            }
            return;
        }
    }

    public static int removeData(int stackNumber) {
        if (stackNumber == 1) {
            if (array1size == 0) {
                System.out.println("Stack Underflow");
                return 0;
            }
            return array[--array1size];
        }
        if (stackNumber == 2) {
            if (array2size == 0) {
                System.out.println("Stack Underflow");
                return 0;
            }
            return array[size1 + --array2size];
        } else {
            if (array3size == 0) {
                System.out.println("Stack Underflow");
                return 0;
            }
            return array[size1 + size2 + --array3size];
        }
    }

    public static void main(String[] args) {
        ThreeIn1 objThreeIn1 = new ThreeIn1(10);
        Scanner objScanner = new Scanner(System.in);
        while (true) {
            System.out.println("From stack 1, 2 or 3?");
            int stackNumber = objScanner.nextInt();
            if (stackNumber != 1 && stackNumber != 2 && stackNumber != 3) {
                break;
            }
            switch (stackNumber) {
            case 1:
            case 2:
            case 3:
                int data;
                System.out.println("1. Push\n2. Pop\n3. Display\n4. Exit");
                int choice = objScanner.nextInt();
                if (choice != 1 && choice != 2 && choice != 3) {
                    break;
                }
                switch (choice) {
                case 1:
                    System.out.println("Enter a data-integer");
                    data = objScanner.nextInt();
                    insertData(stackNumber, data);
                    break;
                case 2:
                    data = removeData(stackNumber);
                    System.out.println("Data removed is " + data);
                    break;
                case 3:
                    displayData(stackNumber);
                    break;
                }
                break;
            }
        }
    }
}
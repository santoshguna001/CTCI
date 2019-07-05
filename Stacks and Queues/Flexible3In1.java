class Flexible3In1 {
    static int NumberStacks, eachSize, size;
    static int[] array, sizes;
    static SingleStack[] stacks;

    static class SingleStack {
        private int start, end, index;

        SingleStack(int start, int end) {
            this.start = start;
            this.end = end;
            index = start;
        }
    }

    public static void displayAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int removeData(int stackNumber) {
        if (stackNumber >= 0 && stackNumber < stacks.length) {
            if (stacks[stackNumber].index == stacks[stackNumber].start) {
                System.out.println("Stack Underflow");
                return 0;
            } else {
                return array[stacks[stackNumber].index--];
            }
        } else {
            System.out.println("Not a valid stack number");
            return 0;
        }
    }

    Flexible3In1(int numberStacks, int size) {
        array = new int[size];
        NumberStacks = numberStacks;
        sizes = new int[numberStacks];
        stacks = new SingleStack[numberStacks];
        int fixed_size = size;
        int start = 0, end = 0;
        for (int i = 0; i < numberStacks; i++) {
            eachSize = size / (numberStacks - i);
            size -= eachSize;
            end += eachSize;
            SingleStack s = new SingleStack(start, end);
            stacks[i] = s;
            start = end;
        }
        this.size = fixed_size;

    }

    public static void insertData(int stackNumber, int data) {
        if (stackNumber >= 0 && stackNumber < stacks.length) {
            if (stacks[stackNumber].index == stacks[stackNumber].end) {
                System.out.println("Stack Overflow on insertion of data " + data);
                int i = stacks[stackNumber].index + 1;
                if (i >= size) {
                    i = 0;
                }
                for (;;) {
                    // System.out.println(i);
                    if (i == stacks[stackNumber].index) {
                        System.out.println("No empty space found");
                        break;
                    }
                    if (i == size) {
                        i = 0;
                        continue;
                    }
                    if (array[i] == 0) {
                        System.out.println("For " + data + ", Empty space found at index " + i);
                        makeSpaceAndInsert(stackNumber, data, i, stacks[stackNumber].index);
                        break;
                    }
                    i++;
                }
            } else {
                int index = stacks[stackNumber].index;
                array[index] = data;
                stacks[stackNumber].index++;
            }
        } else {
            System.out.println("Not a valid stack number");
            return;
        }
    }

    public static void makeSpaceAndInsert(int stackNumber, int data, int index, int actual_index) {
        int count = 0;
        for (SingleStack s : stacks) {
            if (index >= s.start && index < s.end) {
                break;
            }
            count++;
        }

        stacks[stackNumber].index++;
        if (stacks[stackNumber].index == size + 1) {
            stacks[stackNumber].index = 1;
        }
        stacks[stackNumber].end++;
        if (stacks[stackNumber].end == size + 1) {
            stacks[stackNumber].end = 1;
        }
        // System.out.println(count);
        stacks[count].index++;
        if (stacks[count].index == size + 1) {
            stacks[count].index = 1;
        }
        stacks[count].start++;
        if (stacks[count].start == size + 1) {
            stacks[count].start = 1;
        }
        if (actual_index > index) {
            for (int i = stackNumber + 1;; i++) {
                if (i == count) {
                    break;
                }
                if (i == NumberStacks) {
                    i = -1;
                    continue;
                }
                stacks[i].end++;
                if (stacks[i].end == size + 1) {
                    stacks[i].end = 1;
                }
                stacks[i].index++;
                if (stacks[i].index == size + 1) {
                    stacks[i].index = 1;
                }
                stacks[i].start++;
                if (stacks[i].start == size + 1) {
                    stacks[i].start = 1;
                }
            }

            for (int i = index; i > 0; i--) {
                array[i] = array[i - 1];
            }
            if (stacks[stackNumber].index == 1) {
                array[0] = data;
            } else {
                array[0] = array[size - 1];
                for (int i = size - 1; i > stacks[stackNumber].end - 1; i--) {
                    array[i] = array[i - 1];
                }
                if (actual_index == size) {
                    actual_index = actual_index % size;
                }
                array[actual_index] = data;
            }
        } else {
            stacks[count].end--;
            for (int i = stackNumber + 1; i < count; i++) {
                stacks[i].start++;
                stacks[i].end++;
            }
            for (int i = index; i > actual_index; i--) {
                array[i] = array[i - 1];
            }
            array[actual_index] = data;
        }

    }

    public static void main(String[] args) {
        Flexible3In1 objFlexible3In1 = new Flexible3In1(3, 7);
        insertData(2, 5);
        insertData(2, 6);
        insertData(2, 9);

        insertData(1, 7);
        insertData(0, 4);
        insertData(2, 8);
        insertData(2, 10);
        // 81047569
        displayAll();
        System.out.println("\tStart:    End:    Index");
        int count = 0;
        for (SingleStack s : stacks) {
            System.out.println("Stack " + ++count + ":    " + s.start + " \t    " + s.end + " \t     " + s.index);
        }
    }
}
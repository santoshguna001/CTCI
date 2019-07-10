/** 11011101111 */
class FlipBitToWin {
    public static void main(String[] args) {
        int n = 1775;
        int n1 = 0b11011100111;
        System.out.println(" " + getMaximumSequences(n));
    }

    // Without using String O(1) space and O(b) run time
    public static int getMaximumSequences(int n) {
        int result = 0;
        int start = 0, end = 0, last_flipped = 0, i = 0;
        boolean flipped = false;
        while (!((n == 0) && flipped)) {
            if (i != 0) {
                n = n >> 1;
            }
            if ((n & 1) == 1) {
                end = i;
                i++;
                continue;
            }

            // Flip the first time
            if (!flipped) {
                end = i;
                flipped = true;
                last_flipped = i + 1;
                i++;
                continue;
            }

            if (result < end - start + 1) {
                result = end - start + 1;
            }
            start = last_flipped;
            i++;
        }
        if (result < end - start + 1) {
            result = end - start + 1;
        }
        return result;
    }

    // using String -- O(b) space and O(b) time where b is the number of times to
    // hold n
    public static int getMaximumSequence(int n) {
        int result = 0;
        String number = Integer.toBinaryString(n);
        int start = 0, end = 0, last_flipped = 0;
        boolean flipped = false;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '1') {
                end = i;
                continue;
            }
            if (!flipped) {
                end = i;
                flipped = true;
                last_flipped = i + 1;
                continue;
            }
            if (result < end - start + 1) {
                result = end - start + 1;
            }
            start = last_flipped;
        }
        if (result < end - start + 1) {
            result = end - start + 1;
        }
        return result;
    }
}
class TripleStep {
    static int count = 0;

    // Complexity is O(3^n)
    public static int getNumberOfWays(int n) {
        if (n <= 0) {
            return count++;
        } else {
            getNumberOfWays(n - 1);
            if (n >= 2) {
                getNumberOfWays(n - 2);
            }
            if (n >= 3) {
                getNumberOfWays(n - 31);
            }
            return count;
        }
    }

    // Complexity is O(n)
    public static int getNumberOfWay(int n, Integer[] cache) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (cache[n] != null) {
            return cache[n];
        } else {
            return getNumberOfWay(n - 1, cache) + getNumberOfWay(n - 2, cache) + getNumberOfWay(n - 3, cache);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        Integer[] cache = new Integer[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        System.out.println(getNumberOfWay(n, cache));
    }
}
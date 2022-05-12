public class Fibonacci {
    static long[] fibCache;
    public static void main(String[] args) {
        int n = 50;
        fibCache = new long[n + 1];
        System.out.println(fibRecursive(n));
    }


    public static long fibRecursive(int n) {
        //ensure recursion has break point
        if (n <= 1) {
            return n;
        }
        /*
        store n in an array for future retrieval
        this concept is call memoization
        with the array, the function would have to continually call down
        the chain every time it's called recursively
         */
        if (fibCache[n] != 0) {
            return fibCache[n];
        }
        /*
        n is simply the sum of (n - 1) and (n - 2)
        to improve performance, the nth fibonacci is stored in an array at index n
        then is returned to continue the sequence
         */
        long nthFib = fibRecursive(n - 1) + fibRecursive(n - 2);
        fibCache[n] = nthFib;
        return nthFib;
    }
}

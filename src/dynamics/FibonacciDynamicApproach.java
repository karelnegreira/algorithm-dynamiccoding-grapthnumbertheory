package dynamics;

public class FibonacciDynamicApproach {
    public static void main(String... args) {
        FibonacciDynamicApproach fib = new FibonacciDynamicApproach();
        fib.initialize();
        System.out.println(fib_memoization_dynamic_approach(400));
        System.out.println(fib_tabulation_dynamics(400));
    }

    /*
    * Tabulation (bottom-up - de abajo hacia arriba) is another Dynamic coding
    * approach for the same problem of overlapping solutions of the subproblems.
    * Say here, the table is filled in bottom-up fashion and we return the
    * last entry from the table. For example, for computing fib(n), we start
    * computing fib(0) then fib(1) then fib(2) and so on...
    * so literally we are building the solutions of subproblems bottom-up,
    *
    * */
    public static int fib_tabulation_dynamics(int n) {
        int[] FIB = new int[n + 1];
        FIB[0] = 0;
        FIB[1] = 1;

        for (int i = 2; i <= n; i++) {
            FIB[i] = FIB[i - 1] + FIB[i - 2];
        }
        return FIB[n];
    }

    /*
    * Dynamic approach 1: Memoization, top - down:
    * here we initialize a table first with all cells
    * in NIL, then we start computing, if a new value
    * of computing is in the table, we take it and no
    * need to computing it again, if after looking up
    * in the table the value is not there, we compute it
    * and then store it...
    * */
    final static int MAX = 900;
    final static int NIL = -1;
    static int loopup[] = new int[MAX];

    public void initialize() {
        for (int i = 0; i < MAX; i++) {
            loopup[i] = NIL;
        }

    }
    public static int fib_memoization_dynamic_approach(int n) {

        if (loopup[n] == NIL) { // if the value doesn't exist in the look-up table
            if (n <= 1) {
                loopup[n] = n;
            } else {
                loopup[n] = fib_memoization_dynamic_approach(n - 1)
                        + fib_memoization_dynamic_approach(n - 2);
            }
        }
        return loopup[n];       // if the value exists, then return it...
    }

    /*
    *Naive solution by recursive approach,
     * plenty overlapping computing along the way
     */
    public static int fib_recursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fib_recursive(n - 1) + fib_recursive(n - 2);
    }
}

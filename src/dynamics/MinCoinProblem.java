package dynamics;

/*
* The problem is very popular, it consists in given a set of coins,
* provide the minimun number of those which sum equals a certain
* arbitrary value V. The algorithm in general could be
* drafted in the following way:
*
* 1. If V == 0, then 0 coins required.
  2. If V > 0
   minCoins(coins[0..m-1], V) = min {1 + minCoins(V-coin[i])}
                               where i varies from 0 to m-1
                               and coin[i] <= V
* */
public class MinCoinProblem {
    public static void main(String... args) {
        int coins[] = {9, 6, 5, 1};
        int m = coins.length;
        int V = 20;
        System.out.println(minCoinDynamic(coins, m, V));
    }

    /*
    * By trying the dynamic tabulation approach, we can
    * skip recomputing the subproblems again and again
    * */
    public static int minCoinDynamic(int[] coins, int m, int V) {
        // table[i] will be storing
        // the minimum number of coins
        // required for i value. So
        // table[V] will have result
        int[] table = new int[V + 1];
        //Base case (if the given V is zero)
        table[0] = 0;
        //initialize all table values to infinite
        for (int i = 1; i <= V; i++) {
            table[i] = Integer.MAX_VALUE;
        }
        //compute the minimum coins required for all'
        //values from 1 to V...
        for (int i = 1; i <= V; i++) {
            //Go though all coins smaller than i...
            for (int j = 0; j < m; j++) {
                if (coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i]) {
                        table[i] = sub_res + 1;
                    }
                }
            }
        }
        if (table[V] == Integer.MAX_VALUE) {
            return -1;
        }
        return table[V];
    }
    /*Naive solution by using recursive approach, Time complexity O(m*2^n)
    * overlapping all over the place. Dynamic solution required.
    * */
    public static int minCoin(int[] coins, int m, int V) {
        if (V == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (coins[i] <= V) {
                int sub_res = minCoin(coins, m, V - coins[i] );
                //check for INT_MAX for avoiding stack overflow and see if
                //the result can be minimized.
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) {
                    res = sub_res + 1;
                }
            }
        }
        return res;
    }
}
package dynamicproblems;

/*
* Given a rod of length n inches and an array of prices that includes prices of all pieces of
* size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling t
* he pieces. For example, if the length of the rod is 8 and the values of different pieces are given
* as the following,
*
* length   | 1   2   3   4   5   6   7   8
--------------------------------------------
* price    | 1   5   8   9  10  17  17  20
*
* then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
*
* And if the prices are as following, then the maximum obtainable value is 24
* (by cutting in eight pieces of length 1)

* length   | 1   2   3   4   5   6   7   8
--------------------------------------------
* price    | 3   5   8   9  10  17  17  20

 * */

public class CutRoadProblem {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = arr.length;

        System.out.println(cutRoad(arr, n));
    }

    /*
    * Let cutRod(n) be the required (best possible price) value for a rod of length n.
    * cutRod(n) can be written as follows.
    * cutRod(n) = max(price[i] + cutRod(n-i-1)) for all i in {0, 1 .. n-1}
    * */

    private static int cutRoad(int[] prices, int n) {
        int[] table = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max_val = Math.max(max_val, prices[j] + table[i - j - 1]);
            }
            table[i] = max_val;
        }
        return table[n];
    }

}

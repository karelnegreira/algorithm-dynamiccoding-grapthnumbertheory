package dynamicproblems;

/*
 * Consider a row of n coins of values v1 . . . vn, where n is even. We play a game against
 * an opponent by alternating turns. In each turn, a player selects either the first or
 * last coin from the row, removes it from the row permanently, and receives the value of the coin.
 * Determine the maximum possible amount of money we can definitely win if we move first.
 * */

// Java program to find out maximum
// value from a given sequence of coins

public class OptimalGameStrategy {

    public static void main(String[] args) {
        int arr1[] = { 8, 15, 3, 7 };
        int n = arr1.length;
        System.out.println(
                ""
                        + game(arr1, n));

        int arr2[] = { 2, 2, 2, 2 };
        n = arr2.length;
        System.out.println(
                ""
                        + game(arr2, n));

        int arr3[] = { 20, 30, 2, 2, 2, 10 };
        n = arr3.length;
        System.out.println(
                ""
                        + game(arr3, n));
    }

    static int game(int[] arr, int n) {
        int[][] table = new int[n][n];
        int gap, i, j, x, y, z;

        for (gap = 0; gap < n; gap++) {
            for (i = 0, j = gap; j < n; i++, j++) {
                x = ((i + 2) <= j) ? table[i + 2][j] : 0;
                y = ((i + 1) <= (j - 1)) ? table[i + 1][j - 1] : 0;
                z = (i <= (j - 2)) ? table[i][j - 2] : 0;

                table[i][j] = Math.max(
                        arr[i] + Math.min(x, y),
                        arr[j] + Math.min(y, z)
                );
            }
        }

        return table[0][n - 1];
    }

    // Returns optimal value possible
    // that a player can collect from
    // an array of coins of size n.
    // Note than n must be even
    private static int optimalStrategySolutionGame(int[] arr3, int n) {
        //create a table to store
        //the solution of the subproblems
        int[][] table = new int[n][n];
        int gap, i, j, x, y, z;
        // Fill table using above recursive formula.
        // Note that the tableis filled in diagonal
        // fashion (similar to http:// goo.gl/PQqoS),
        // from diagonal elements to table[0][n-1]
        // which is the result.
        for (gap = 0; gap < n; gap++) {
            for (i = 0, j = gap; j < n; i++, j++) {
                // Here x is value of F(i+2, j),
                // y is F(i+1, j-1) and z is
                // F(i, j-2) in above recursive formula
                x = ((i + 2) <= j) ? table[i + 2][j] : 0;
                y = ((i + 1) <= (j - 1)) ? table[i + 1][j - 1] : 0;
                z = (i <= (j - 2)) ? table[i][j - 2] : 0;

                table[i][j] = Math.max(
                        arr3[i] + Math.min(x, y),
                        arr3[j] + Math.min(y, z)
                );
            }
        }
        return table[0][n - 1];
    }


}

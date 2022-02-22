package dynamicproblems;
/*
 * se tiene un arreglo de valores y otro con el peso de cada
 * uno, se desea determinar la combinacion que hace que
 * la suma de los valores sea maxima. Se tiene un limite en el peso.
 *
 * Given weights and values of n items, put these items in a knapsack of capacity W to get
 * the maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1]
 * and wt[0..n-1] which represent values and weights associated with n items respectively.
 *  Also given an integer W which represents knapsack capacity, find out the maximum value subset
 *  of val[] such that sum of the weights of this subset is smaller than or equal to W.
 * */
public class KnapsackProblem {
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        int n = val.length;

        System.out.println("OPTIMAL: " + knapsack(W, val, wt, n));
    }

    private static int knapsack(int W, int[] val, int[] wt, int size) {
        int[][] K = new int[size + 1][W + 1];
        int i, j;

        for (i = 0; i <= size; i++) {
            for (j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    K[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    K[i][j] = Math.max(val[i - 1] + K[i - 1][j - wt[i - 1]],K[i - 1][j] );
                } else {
                    K[i][j] = K[i - 1][j];
                }
            }
        }
        return K[size][W];
    }


}

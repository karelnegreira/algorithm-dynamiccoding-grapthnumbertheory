package dynamicproblems;

import java.util.Arrays;
/*
 *
 * Given a value N, if we want to make change for N cents,
 * and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
 * how many ways can we make the change? The order of coins doesn’t matter.
 * For example, for N = 4 and S = {1,2,3}, there are four solutions:
 * {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6},
 * there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 * So the output should be 5.
 * */
public class CoinChange {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        int m = array.length;
        int n = 4;

        System.out.println(coinchange(array, m, n));
    }

    private static int coinchange(int[] S, int m, int n) {
        int table[] = new int[n + 1];
        Arrays.fill(table, 0);
        table[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = S[i]; j <= n; j++) {
                table[j] += table[j - S[i]];
            }
        }

        return table[n];
    }

}

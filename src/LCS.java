/*
* The longest common subsquence is another classical
* problems in dynamics coding. The program will
* compute how many characters not neceserely sussesives
*   are common between 2 strings. It is widely used in
* bioinformatics (genetic chains comparisons) and it is the base
* of the algorithm of 2 files comparison.
* */
public class LCS {
    public static void main(String... args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        char[] X = str1.toCharArray();
        char[] Y = str2.toCharArray();
        int lcs = LCS(X, Y, X.length, Y.length);

        System.out.println(lcs);
    }

    /*
    Following steps build L[m+1][n+1] in bottom up fashion. Note
        that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
        Time: O(m*n) Space O(m + n)
         */

    public static int LCS(char[] X, char[] Y, int m, int n) {
        int[][] L = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (X[i - 1] == Y[j - 1]) {
                    L[i][j] = 1 + L[i - 1][j - 1];
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        return L[m][n];
    }

    /*
    * Naive recursive approach,
    * overlapping issues in the solution
    * O(n*2^n)
    * */
    public static int LCS_recursive(char[] X, char[] Y, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (X[m - 1] == Y[n - 1]) { //if lasts elements are same, count it...
            return 1 + LCS_recursive(X, Y, m - 1, n - 1);
        } else {
            return Math.max(LCS_recursive(X, Y, m, n - 1), //
                    LCS_recursive(X, Y, m - 1, n));
        }
    }

    public static int LCS(String str1, String str2, int m, int n) {
        int[][] DP = new int[m + 1][n + 1];

        return 0;
    }
}

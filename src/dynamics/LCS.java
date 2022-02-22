package dynamicproblems;
/*
 * The problem of the LCS is basically to find the
 * longest sequence of characters, not necessarily
 * continuous, which represent a common set between
 * two Strings
 * */
public class LCS {
    public static void main(String[] args) {
        String text1 = "AGGTAB";
        String text2 = "GXTXAYB";

        System.out.println(lcs(text1, text2, text1.length(), text2.length()));
    }

    private static int lcs(String X, String Y, int m, int n) {
        int[][] L = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    L[i][j] = 1 + L[i - 1][j - 1];
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        return L[m][n];
    }


}

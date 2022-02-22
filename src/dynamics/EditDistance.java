package dynamicproblems;

/*
 * How many operations (insert, replace, remove) are necessary
 * to equal 2 strings.
 * ALGORITHM PSEUDOCODE
 *
 * 1. If last characters of two strings are same, nothing much to do.
 * Ignore last characters and get count for remaining strings. So we recur for lengths m-1 and n-1.
*  2. Else (If last characters are not same), we consider all operations on ‘str1’,
* consider all three operations on last character of first string,
* recursively compute minimum cost for all three operations and take minimum of three values.
Insert: Recur for m and n-1
Remove: Recur for m-1 and n
Replace: Recur for m-1 and n-1
 * */

public class EditDistance {
    public static void main(String[] args) {
        String str1 = "Sunday";
        String str2 = "Saturday";
        System.out.println(editdistance(str1, str2, str1.length(), str2.length()));
    }

    private static int editdistance(String str1, String str2, int m, int n) {
        int[][] DP = new int[2][m + 1];

        for (int i = 0; i <= m; i++) {
            DP[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j == 0) {
                    DP[i % 2][j] = i;
                } else if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
                    DP[i % 2][j] = DP[(i - 1) % 2][j - 1];
                } else {
                    DP[i % 2][j] = 1 + Math.min(DP[(i - 1) % 2][j], //insert
                            Math.min(DP[i % 2][j - 1],              //replace
                                    DP[(i - 1) % 2][j - 1])) ;       //remove
                }
            }
        }
        return DP[n % 2][m];
    }


}

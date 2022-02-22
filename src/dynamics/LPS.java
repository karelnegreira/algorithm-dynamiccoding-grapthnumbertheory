package dynamics;

/*
* THe current problem looks for the longest,
* palindrome substring in a given one.
*
*   1. Maintain a boolean table[n][n] that is filled in bottom up manner.
    2. The value of table[i][j] is true, if the substring is palindrome, otherwise false.
    3. To calculate table[i][j], check the value of table[i+1][j-1], if the value is true and str[i] is same as str[j], then we make table[i][j] true.
    4. Otherwise, the value of table[i][j] is made false.
    5. We have to fill table previously for substring of length = 1 and length =2 because
    as we are finding , if table[i+1][j-1] is true or false , so in case of
    (i) length == 1 , lets say i=2 , j=2 and i+1,j-1 doesn’t lies between [i , j]
    (ii) length == 2 ,lets say i=2 , j=3 and i+1,j-1 again doesn’t lies between [i , j].
*
* Auxiliary space = O(x^2) Auxiliary time: O(x^2)
* */
public class LPS {
    public static void main(String... args) {
        String str = "forgeeksskeegfor";
        System.out.println("Length is: " + longestPalSubstring(str));
    }

    // This function prints the longest
    // palindrome substring of str[].
    // It also returns the length of the
    // longest palindrome
    static int longestPalSubstring(String str) {
        //get the length of input string
        int n = str.length();
        // table[i][j] will be false if
        // substring str[i..j] is not palindrome.
        // Else table[i][j] will be true
        boolean[][] table = new boolean[n + 1][n + 1];
        //all substrings are palindromes of length 1
        int max_length = 1;
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }
        //check for substring of length 2
        int start = 0;
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                max_length = 2;
            }
        }
        //check for lengths greater than 2
        //k is length of substring
        for (int k = 3; k <= n; k++) {
            //fix the starting index
            for (int i = 0; i < n - k + 1; i++) {
                //Get the ending index of substring
                //starting index i and length k
                int j = i + k - 1;
                if (table[i + 1][j - 1] && (str.charAt(i) == str.charAt(j))) {
                    table[i][j] = true;
                    if (k > max_length) {
                        start = i;
                        max_length = k;
                    }
                }
            }
        }
        System.out.println("The longest palindrome substring is: ");
        printStr(str, start, start + max_length - 1);

        return max_length;
    }

    static void printStr(String str, int low, int high) {
        System.out.println(str.substring(low, high));
    }
}

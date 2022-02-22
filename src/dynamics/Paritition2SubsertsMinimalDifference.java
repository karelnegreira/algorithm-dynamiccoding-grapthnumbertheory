package dynamicproblems;

/*
* Given a set of integers, the task is to divide it into two sets S1 and S2
* such that the absolute difference between their sums is minimum.
* If there is a set S with n elements, then if we assume Subset1 has m elements,
* Subset2 must have n-m elements and the value
* of abs(sum(Subset1) – sum(Subset2)) should be minimum.
*
* Example:

Input:  arr[] = {1, 6, 11, 5}
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11}, sum of Subset2 = 11
 * */

public class Paritition2SubsertsMinimalDifference {
    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 2, 2, 1 };
        int n = arr.length;

        System.out.println("The minimum difference"
                + " between two sets is "
                + findMinDynamic(arr, n));
    }

    static int findMinDynamic(int[] arr, int n) {
        //calculates the sum of all elements
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        //creates an array of booleans
        //to store the result of subproblems
        boolean[][] DP = new boolean[n + 1][sum + 1];
        //initialize first column true
        //0 sum is possible with all elements
        for (int i = 0; i <= n; i++) {
            DP[i][0] = true;
        }
        // Initialize top row, except dp[0][0],
        // as false. With 0 elements, no other
        // sum except 0 is possible
        for (int i = 1; i <= sum; i++) {
            DP[0][i] = false;
        }
        //fill the table in a bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                //if the ith element is excluded
                DP[i][j] = DP[i - 1][j];
                //if the ith element is included
                if (arr[i - 1] <= j) {
                    DP[i][j] |= DP[i - 1][j - arr[i - 1]];
                }
            }
        }
        //initialize the difference of the two sums
        int diff = Integer.MAX_VALUE;
        //find the largest j such that DP[n][j]
        //is true where j loops from sum/2 to 0
        for (int j = sum / 2; j >= 0; j-- ) {
            if (DP[n][j] == true) {
                diff = sum - 2*j;
                break;
            }
        }
        return diff;
    }

    static int findMin(int[] arr, int n) {
        //compute total sum of elements.
        int sumTotal = 0;
        for (int i = 0; i < n; i++) {
            sumTotal += arr[i];
        }
        return findMinRec(arr, n, 0, sumTotal);
    }

    private static int findMinRec(int[] arr, int i, int sumCalculated, int sumTotal) {
        // If we have reached last element.
        // Sum of one subset is sumCalculated,
        // sum of other subset is sumTotal-
        // sumCalculated.  Return absolute
        // difference of two sums.
        if (i == 0) {
            return Math.abs((sumTotal - sumCalculated) - sumCalculated);
        }
        // For every item arr[i], we have two choices
        // (1) We do not include it first set
        // (2) We include it in first set
        // We return minimum of two choices
        return Math.min(findMinRec(arr, i - 1, sumCalculated + arr[i - 1], sumTotal),
                findMinRec(arr, i - 1, sumCalculated, sumTotal));

    }

}

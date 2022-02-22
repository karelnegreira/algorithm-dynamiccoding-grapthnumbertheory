package dynamics;

/*
* Given a set of non-negative integers, and a value sum,
* determine if there is a subset of the given set with sum equal to given sum.
* EXAMPLE:
 *Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True
There is a subset (4, 5) with sum 9.
 *  */
public class SubsetSumProblem {
    public static void main(String[] args) {
        int[] array = {3, 5, 7, 1, 4, 7};
        System.out.println(isSubSetSum_tabular_dynamic(array, array.length, 11));
    }
    /*
    * So we will create a 2D array of size (arr.size() + 1) * (target + 1) of type boolean.
    *  The state DP[i][j] will be true if there exists a subset of elements from A[0….i]
    *  with sum value = ‘j’. The approach for the problem is:

if (A[i-1] > j)
DP[i][j] = DP[i-1][j]
else
DP[i][j] = DP[i-1][j] OR DP[i-1][j-A[i-1]]

    This means that if current element has value greater than ‘current sum value’ we will
    * copy the answer for previous cases
    And if the current sum value is greater than the ‘ith’ element we will see
    * if any of previous states have already experienced the sum=’j’ OR any previous states
    * experienced a value ‘j – A[i]’ which will solve our purpose.
    * */
    static boolean isSubSetSum_tabular_dynamic(int[] array, int n, int sum) {
        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        boolean subset[][] = new boolean[sum + 1][n + 1];
        //if sum is 0, the answer is true...
        for (int i = 0; i <= n; i++) {
            subset[0][i] = true;
        }
        //if the sum is not zero and set is empty,
        //subset is false...
        for (int i = 0; i < sum; i++) {
            subset[i][0] = false;
        }
        //fill the subset table in bottom up manner - tabular approach
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= array[j - 1]) {
                    subset[i][j] = subset[i][j]
                            || subset[i - array[j - 1]][j - 1];
                }
            }
        }
        /*
        * Comment the following if dont wanna see the subset matrix
        * */
        for (int i = 0; i < sum; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(subset[i][j] + "  ");
            }
            System.out.println();
        }
        return subset[sum][n];
    }

    /*Naive recursive approach
    * Approach: For the recursive approach we will consider two cases.

    Consider the last element and now the required sum = target sum – value of ‘last’ element and number of elements = total elements – 1
    Leave the ‘last’ element and now the required sum = target sum and number of elements = total elements – 1

Following is the recursive formula for isSubsetSum() problem.

isSubsetSum(set, n, sum)
= isSubsetSum(set, n-1, sum) ||
  isSubsetSum(set, n-1, sum-set[n-1])
Base Cases:
isSubsetSum(set, n, sum) = false, if sum > 0 and n == 0
isSubsetSum(set, n, sum) = true, if sum == 0
    * */
    static boolean isSubsetSum_recursive(int[] array, int n, int sum) {
        if (n == 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        //if the sum is smaller than the last element of the array, exclude it...
        if (sum < array[n - 1]) {
            return isSubsetSum_recursive(array, n - 1, sum);
        }
        /* else, check if sum can be obtained
        by any of the following
            (a) including the last element
            (b) excluding the last element */
        return isSubsetSum_recursive(array, n - 1, sum)
                || isSubsetSum_recursive(array, n - 1,
                sum - array[n - 1]);
    }
}

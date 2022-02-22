package dynamicproblems;

/*
* Partition problem is to determine whether a given set can be partitioned
*  into two subsets such that the sum of elements in both subsets is the same.
*
* Examples:

arr[] = {1, 5, 11, 5}
Output: true
The array can be partitioned as {1, 5, 5} and {11}

arr[] = {1, 5, 3}
Output: false
The array cannot be partitioned into equal sum sets.
*
1) Calculate sum of the array. If sum is odd,
* there can not be two subsets with equal sum, so return false.
2) If sum of array elements is even, calculate sum/2
* and find a subset of array with sum equal to sum/2.
*
*
* Time Complexity: O(2^n) -- recursive solution
 * */
public class PartitionProblem {
    public static void main(String[] args) {
        int arr[] = { 3, 1, 5, 9, 12 };
        int n = arr.length;

        // Function call
        if (findPartitionDynamically(arr, n) == true)
            System.out.println("Can be divided into two "
                    + "subsets of equal sum");
        else
            System.out.println(
                    "Can not be divided into "
                            + "two subsets of equal sum");
    }

    public static boolean findPartitionDynamically(int[] arr, int n) {
        int sum = 0;
        int i, j;
        for (i = 0; i < n; i++) {
            sum += arr[i];
        }
        //if the sum is not even, then is false...
        if (sum % 2 != 0) {
            return false;
        }
        boolean[][] DP = new boolean[sum / 2 + 1][n + 1];   // --> DP[col = SUM / 2 + 1][row = n + 1]
        //initialize the top row as true
        for (i = 0; i <= n; i++) {
            DP[0][i] = true;
        }
        //initialize the leftmost column as false, excepting DP[0][0]
        for (j = 1; j <= sum / 2; j++) {
            DP[j][0] = false;
        }
        //Fill the partition table in a bottom-up manner
        for (i = 1; i <= sum / 2; i++) {
            for (j = 1; j <= n; j++) {
                DP[i][j] = DP[i][j - 1];
                if (i >= arr[j - 1]) {
                    DP[i][j] = DP[i][j] || DP[i - arr[j - 1]][j - 1];
                }
            }
        }

        for (i = 0; i <= sum / 2; i++) {
            for (j = 0; j <= n; j++) {
                System.out.print( DP[i][j] + "   ");
            }
            System.out.println();
        }

        return DP[sum / 2][n];
    }

    //returns true if the array can be partitionate in two..
    //subsets of equal sum, otherwise false.
    public static boolean findPartition(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        //if the sum is not even, then there is no way
        //you can find sum / 2 in the integer numbers,
        //so return false.
        if (sum % 2 != 0) {
            return false;
        }
        return isSubsetSumRecursive(arr, arr.length, sum / 2);
    }

    public static boolean isSubsetSumRecursive(int[] arr, int n, int halftedSum) {
        //base cases:
        if (halftedSum == 0) {
            return true;
        }
        if (n == 0 && halftedSum != 0) {
            return false;
        }
        //if the last element is greater than the sum, ignore it...
        if (arr[n - 1] > halftedSum) {
            return isSubsetSumRecursive(arr, n - 1, halftedSum);
        }
        //else, check if the sum can be obtained by any of the following:
        //(a) including the last element
        //(b) excluding the last element
        return isSubsetSumRecursive(arr, n - 1, halftedSum)
                || isSubsetSumRecursive(arr, n - 1,
                halftedSum - arr[n - 1]);
    }
    
}

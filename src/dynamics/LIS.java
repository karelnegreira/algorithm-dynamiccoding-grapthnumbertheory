package dynamicproblems;
/*
 *This is a problem where we find the longest increasing subsequence in a given array, example:
 * lets array {10, 12, 33, 5, 2, 55}, here the LIS is {10, 12, 33, 55} so the result is 4.
 * */

public class LIS {
    public static void main(String[] args) {
        int[] array = {10, 12, 33, 5, 2, 55};
        int n = array.length;

        System.out.println("the length of the longest " +
                "increasing subsequence in the given array is "
                + lis(array, n) );
    }

    static int lis(int[] array, int n) {
        int[] table = new int[n];
        int i, j;
        int max = 0;

        for (i = 0; i < n; i++) {
            table[i] = 1;
        }

        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (array[i] > array[j] && (table[i] < table[j] + 1)) {
                    table[i] = table[j] + 1;
                }
            }
        }

        for (i = 0; i < n; i++) {
            if (max < table[i]) {
                max = table[i];
            }
        }

        return max;
    }
}

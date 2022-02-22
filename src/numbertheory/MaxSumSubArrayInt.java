package numbertheory;
/*
* Kadane’s Algorithm:

Initialize:
    max_so_far = INT_MIN
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
  (c) if(max_ending_here < 0)
            max_ending_here = 0
return max_so_far
*
* The basic idea behind this algorithm is to keep track of
* all positive sums. When it gets a positive (max_ending_here holds the value)
* then it compares it with max_ending_here, if lesser than this one,
* then it updates (max_so_far = max_ending_here)
*
* */
public class MaxSumSubArrayInt {
    public static void main(String... args) {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                findGreaterSumSubArray(a, a.length));
    }

    public static int findGreaterSumSubArray(int[] array, int size) {
        int max_ending_here = 0;
        int max_so_far = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {                     // loops through the array,
            max_ending_here = max_ending_here + array[i];   // holding the sums from index 0 .. i
            if (max_so_far < max_ending_here) {             // if max_so_far less than max_ending_here; updates
                max_so_far = max_ending_here;
            }
            if (max_ending_here < 0) {                      //if max_ending_here less than 0...
                max_ending_here = 0;
            }
        }
        return max_so_far;
    }
}

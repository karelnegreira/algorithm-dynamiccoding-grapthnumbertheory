package dynamicproblems;

public class CoverDistance {
    public static void main(String[] args) {
        System.out.println(coverdistance(4));
    }
    /*
     * MORE OPTIMAL SOLUTION
     *     Create an array of size 3 and initialize the values for step 0,1,2 as 1,1,2 (Base cases).
     *     Run a loop from 3 to n(dist).
     *     For each index compute the value as ways[i%3] = ways[(i-1)%3] + ways[(i-2)%3] + ways[(i-3)%3]
     *     and store its value at i%3 index of array ways. If we are computing value for index 3 then the computed
     *     value will go at index 0 because for larger indices(4 ,5,6…..) we don’t need the value of index 0.
     *     Return the value of ways[n%3].
     * */
    static int coverdistance(int n) {
        int[] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;
        ways[2] = 2;

        for (int i = 3; i <= n; i++) {
            ways[i % 3] = ways[(i - 1) % 3] + ways[(i - 2) % 3] + ways[(i - 3) % 3];
        }
        return ways[n % 3];
    }
}

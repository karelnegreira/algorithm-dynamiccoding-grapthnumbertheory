package dynamicproblems;

/*
* Given n dice each with m faces, numbered from 1 to m, find the number of ways to get sum X.
* X is the summation of values on each face when all the dice are thrown.
* */

public class DiceThrowProblem {
    public static void main(String[] args) {
        System.out.println(dicethrow(4, 2, 1));
        System.out.println(dicethrow(2, 2, 3));
        System.out.println(dicethrow(6, 3, 8));
        System.out.println(dicethrow(4, 2, 5));
        System.out.println(dicethrow(4, 3, 5));
    }

    private static long dicethrow(int faces, int dice, int sum) {
        long mem[][] = new long[dice + 1][sum + 1];
        mem[0][0] = 1;

        for (int i = 1; i <= dice; i++) {
            for (int j = i; j <= sum; j++) {
                mem[i][j] = mem[i][j - 1] + mem[i - 1][j - 1];
                if (j - faces - 1 >= 0) {
                    mem[i][j] -= mem[i - 1][j - faces - 1];
                }
            }
        }
        return mem[dice][sum];
    }


}

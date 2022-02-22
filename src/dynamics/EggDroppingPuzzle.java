package dynamicproblems;

public class EggDroppingPuzzle {
    public static void main(String[] args) {
        int n = 2, k = 10;

        System.out.print("Minimum number of "
                + "trials in worst case with "
                + n + " eggs and " + k
                + " floors is " + eggflooroptimize(n, k));
    }

    static int eggflooroptimize(int n, int k) {
        int[][] eggfloortable = new int[n + 1][k + 1];
        int res;
        int i, j, x;

        for (i = 1; i <= n; i++) {
            eggfloortable[i][0] = 1;
            eggfloortable[i][1] = 0;
        }

        for (j = 1; j <= k; j++) {
            eggfloortable[1][j] = j;
        }

        for (i = 2; i <= n; i++) {
            for (j = 2; j <= k; j++) {
                eggfloortable[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++) {
                    res = 1 + Math.max(eggfloortable[i - 1][x - 1], eggfloortable[i][j - x]);
                    if (res < eggfloortable[i][j]) {
                        eggfloortable[i][j] = res;
                    }
                }
            }
        }
        return eggfloortable[n][k];
    }

}

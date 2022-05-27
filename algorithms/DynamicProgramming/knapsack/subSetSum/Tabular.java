import java.util.*;

class Tabular {
    static int[][] memo;

    static boolean subSetSum(int[] arr, int n, int k) {
        boolean[][] dp = new boolean[n + 1][k + 1];
        for (int i = 0; i < k + 1; i++) {
            dp[0][i] = true;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // for (int i = 0; i < n + 1; i++) {
        // for (int j = 0; j < k+ 1; j++) {
        // System.out.print(dp[i][j] + " , ");
        // }
        // System.out.println();
        // }
        return dp[n][k];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(subSetSum(arr, n, k));
    }
}
/*
 * input
 * 5
 * 2 3 7 8 10
 * 11
 * output
 * 1
 */
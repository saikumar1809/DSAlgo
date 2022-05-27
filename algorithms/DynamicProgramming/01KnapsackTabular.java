
/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main {
    static int knapsack(int[] wt, int[] val, int n, int w) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < w + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max((val[i - 1] + dp[i - 1][j - wt[i - 1]]), (dp[i - 1][j]));
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // for (int i = 0; i < n + 1; i++) {
        // for (int j = 0; j < w + 1; j++) {
        // System.out.print(dp[i][j] + " , ");
        // }
        // System.out.println();
        // }
        return dp[n][w];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }
        int w = sc.nextInt();
        System.out.println(knapsack(wt, val, n, w));
    }
}

/*
 * Input
 * 
 * 4
 * 1 3 4 5
 * 1 4 5 7
 * 7
 * output
 * 9
 */
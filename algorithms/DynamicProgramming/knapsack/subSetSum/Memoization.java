
import java.util.*;

public class Memoization {
    static int[][] memo;

    static int subSetSum(int arr[], int n, int k) {
        if (k == 0)
            return 1;
        if (n == 0)
            return 0;
        if (memo[n - 1][k] != -1)
            return memo[n - 1][k];
        else {
            if (arr[n - 1] <= k) {
                return memo[n - 1][k] = Math.max(subSetSum(arr, n - 1, k - arr[n - 1]), subSetSum(arr, n - 1, k));
            } else {
                return memo[n - 1][k] = subSetSum(arr, n - 1, k);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        memo = new int[n + 1][k + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                memo[i][j] = -1;
            }
        }
        System.out.println(subSetSum(arr, n, k));
    }
}

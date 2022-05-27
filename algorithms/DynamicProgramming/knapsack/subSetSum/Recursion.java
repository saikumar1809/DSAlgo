
import java.util.*;

public class Recursion {
    static int subSetSum(int arr[], int n, int k) {
        if (k == 0)
            return 1;
        if (n == 0)
            return 0;
        if (arr[n - 1] <= k) {
            return Math.max(subSetSum(arr, n - 1, k - arr[n - 1]), subSetSum(arr, n - 1, k));
        } else {
            return subSetSum(arr, n - 1, k);
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

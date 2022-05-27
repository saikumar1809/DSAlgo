
/*works for non negetive integers*/
import java.util.*;

public class Tabular {
    static ArrayList subSetSum(int arr[], int n, int k) {
        boolean[][] temp = new boolean[n + 1][k + 1];
        for (int j = 0; j < k + 1; j++) {
            temp[0][j] = false;
        }
        for (int i = 0; i < n + 1; i++) {
            temp[i][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (arr[i - 1] <= j) {
                    temp[i][j] = temp[i - 1][j] || temp[i - 1][j - arr[i - 1]];
                } else {
                    temp[i][j] = temp[i - 1][j];
                }
            }
        }
        // for(int i=0;i<n+1;i++){
        // for(int j=0;j<k+1;j++){
        // System.out.print(temp[i][j]+" ");
        // }
        // System.out.println();
        // }
        ArrayList<Integer> validRanges = new ArrayList<Integer>();
        for (int i = 0; i < (k + 1) / 2; i++) {
            if (temp[n][i] == true) {
                validRanges.add(i);
            }
        }
        return validRanges;

    }

    static int minimumSumDifference(int arr[], int n, int range) {
        ArrayList<Integer> validRanges = subSetSum(arr, n, range);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < validRanges.size(); i++) {
            // System.out.print(" "+ validRanges.get(i));
            int val = range - 2 * validRanges.get(i);
            if (val < min) {
                min = val;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        System.out.println(minimumSumDifference(arr, n, sum));
    }
}
/*input
4
3 9 7 3
output 4
*/

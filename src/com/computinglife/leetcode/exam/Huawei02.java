package com.computinglife.leetcode.exam;

import java.util.Scanner;

/**
 * Created by yliu on 8/5/16.
 */
public class Huawei02 {

    public static int stoneGame(int[] A) {
        int m = A.length;
        if (m == 0) return 0;
        if (m == 1) return 0;
        int[][] sum = new int[m][m];
        int[][] dp = new int[m][m];

        for (int i = 0; i < m; ++i) {
            sum[i][i] = A[i];
            for (int j = i + 1; j < m; ++j) {
                sum[i][j] = sum[i][j - 1] + A[j];
            }
        }

        for (int j = 1; j < m; ++j) {
            //dp edge case
            dp[j][j] = 0;

            for (int i = j - 1; i >= 0; --i) {

                int min = Integer.MAX_VALUE;

                //dp common case func
                for (int k = i; k <= j - 1; ++k) {
                    int tmp = dp[i][k] + dp[k + 1][j];
                    if (tmp < min) {
                        min = tmp;
                    }
                }
                dp[i][j] = min + sum[i][j];
            }
        }
        return dp[0][m - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] array = input.split(" ");
        int n = Integer.parseInt(array[0]);
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = Integer.parseInt(array[i]);
        }
        int res = stoneGame(nums);
        System.out.println(res);
    }
}

package com.computinglife.leetcode.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yliu on 7/2/16.
 */
public class Indeed24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        String ballsStr = sc.nextLine();
        String[] ballsArray = ballsStr.split(" ");
        int[] balls = new int[k];
        //format input
        int countBalls = 0;
        int min = Integer.MAX_VALUE;
        double basic = 1;
        for (int i = 0; i < k; i++) {
            balls[i] = Integer.parseInt(ballsArray[i]);
            countBalls += balls[i];
            if (min > balls[i]) {
                min = balls[i];
            }
        }
        for (int i = 0; i < k; i++) {
            basic *= ((double) balls[i] / countBalls);
        }
        double expectedNum = 0;
        Arrays.sort(balls);
        for (int i = k, j = 0; i <= countBalls - min + 1; i++, j++) {
            if (j >= 1)
                expectedNum += i * (basic * Math.pow((double) balls[0] / countBalls, j) + basic * Math.pow((double) balls[1] / countBalls, j));
            else
                expectedNum += i * basic;
        }
        System.out.println(expectedNum);
    }
}

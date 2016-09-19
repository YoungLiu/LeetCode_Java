package com.computinglife.leetcode.exam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by yliu on 9/18/16.
 */
public class GoogleRoundC02 {

    public static void main(String[] args) {
        String filename = "testcase";

        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            Scanner sc = new Scanner(in);
            int caseNum = sc.nextInt();

            for(int i = 0; i < caseNum; i++) {
                int R = sc.nextInt();
                int C = sc.nextInt();
                int K = sc.nextInt();
                int[][] matrix = new int[R][C];
                for(int j = 0; j < K; j++) {
                    int tmpx = sc.nextInt();
                    int tmpy = sc.nextInt();
                    matrix[tmpx][tmpy] = 1;
                }
                // get the squares nums
                int count = 0;
                int minStep = Math.min(R, C);
                for(int step = 0; step < minStep; step++){

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

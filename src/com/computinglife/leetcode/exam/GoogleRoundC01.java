package com.computinglife.leetcode.exam;

import java.util.Scanner;

/**
 * Created by yliu on 9/18/16.
 */
public class GoogleRoundC01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        for(int i = 0; i < testNum; i++) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            int Rs = sc.nextInt();
            int Cs = sc.nextInt();
            int s = sc.nextInt();
            float P = sc.nextFloat();
            float Q = sc.nextFloat();
            String[][] metrix = new String[R][C];
            for(int tmpR = 0; tmpR < R; tmpR++){
                String line = sc.nextLine();
                String[] lineArray = line.split(" ");
                for(int tmpC = 0; tmpC < C; tmpC++){
                    metrix[tmpR][tmpC] = lineArray[tmpC];
                }
            }


        }
    }
}

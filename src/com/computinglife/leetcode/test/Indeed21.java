package com.computinglife.leetcode.test;

import java.util.Scanner;

/**
 * Created by yliu on 7/2/16.
 */
public class Indeed21 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String numLine = sc.nextLine();
        String[] numsStr = numLine.split(",");
        for(String tmp : numsStr){
            System.out.println(tmp);
        }
    }
}

package com.computinglife.leetcode.test;

import java.util.Scanner;

/**
 * Created by yliu on 8/1/16.
 */
public class TestNetease02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int n = Integer.parseInt(input[0]);
            int s = Integer.parseInt(input[1]);
            int l = Integer.parseInt(input[2]);
            int part1 = l / (s + 1);
            
        }
    }
}

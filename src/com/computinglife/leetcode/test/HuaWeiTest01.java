package com.computinglife.leetcode.test;

import java.util.Scanner;

/**
 * Created by yliu on 7/30/16.
 */
public class HuaWeiTest01 {

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            String input = cin.nextLine();
            if (input == null || input.length() == 0) {
                System.out.println(input);
            } else {
                StringBuilder sb = new StringBuilder();
                char[] inputArray = input.toCharArray();
                for(char tmp : inputArray) {
                    if((tmp >= 65 && tmp <= 90)|| tmp == 32) {
                        sb.append(tmp);
                    }
                }
                System.out.println(sb.toString());
            }
        }
    }
}

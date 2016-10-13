package com.computinglife.leetcode.exam;

import java.util.Scanner;

/**
 * Created by yliu on 9/23/16.
 */
public class Xiaomi01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input = sc.nextLine();
            String[] array = input.split(" ");
            if(array.length <= 0){
                continue;
            }
            for(int i = array.length- 1; i >= 1; i--){
                System.out.printf("%s ", array[i]);
            }
            System.out.println(array[0]);
        }
    }
}

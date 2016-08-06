package com.computinglife.leetcode.test;

import java.util.Scanner;

/**
 * Created by yliu on 7/30/16.
 */
public class HuaWeiTest02 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while(sc.hasNext()){
            String input = sc.nextLine();
            if(input == null || input.length() == 0){
                continue;
            } else {
                String[] array = input.split(" ");
                if(array[0].equals("binding")){
                    count += Integer.parseInt(array[1]);
                } else if(array[0].equals("remove")) {
                    if(Integer.parseInt(array[1]) >= count){
                        count = 0;
                    }else {
                        count -= Integer.parseInt(array[1]);
                    }
                } else if(array[0].equals("end")) {
                    System.out.printf("current %d", count);
                } else {
                    continue;
                }
            }
        }
    }
}

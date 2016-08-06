package com.computinglife.leetcode.test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by yliu on 8/2/16.
 */
public class Wangyi01 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while(sc.hasNextLine()){
            String input = sc.nextLine();
            if(input == null || input.length() == 0 || input.equals("\n") || input.equals("\t\n")){
                break;
            }
            String[] array = input.split(" ");
            for(String tmp : array){
                set.add(tmp);
            }
        }
        System.out.println(set.size());
        return;
    }
}

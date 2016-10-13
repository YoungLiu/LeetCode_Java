package com.computinglife.leetcode.exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 题目描述：
 * 给定一个字符串数组，其中一些字符串是由数组中其他两个字符串拼接而成。请找出数组中最长的这样的字符串（假设一定存在；若存在多个，返回一个即可）。
 * 输入
 * 输入是一排字符串，以空格做间隔。
 * 输出
 * 输出满足条件的最长字符串
 * <p>
 * 样例输入
 * test tester testertest testing testingtester
 * 样例输出
 * testingtester
 * Created by yliu on 9/22/16.
 */
public class Hulu01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] array = input.split(" ");
        // check illegal
        if (array.length == 0) {
            System.out.println("");
        }

        // reverse order
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.toString().length() - o1.toString().length();
            }
        });

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : array) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array[i].length(); j++) {
                String str1 = array[i].substring(0, j);
                String str2 = array[i].substring(j, array[i].length());
                if (map.containsKey(str1)){
                    map.put(str1, map.get(str1) - 1);
                    if(map.containsKey(str2) && map.get(str2) != 0){
                        System.out.println(array[i]);
                        return;
                    }
                    map.put(str1, map.get(str1) + 1);
                }
            }
        }
        return;

//        for(int i = 0; i < array.length; i++){
//            if(check(array, array[i], i, array.length, 0)){
//                System.out.println(array[i]);
//                return;
//            }
//        }
//        System.out.println("");
//        return;
    }

    public static boolean check(String[] array, String s, int index, int len, int count) {
        if (count == 1) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        for (int i = index + 1; i < len; i++) {
            if (i != index && s.indexOf(array[i]) == 0) {
                if (check(array, s.substring(array[i].length()), index, len, count++)) {
                    return true;
                }
            }
        }
        return false;
    }
}

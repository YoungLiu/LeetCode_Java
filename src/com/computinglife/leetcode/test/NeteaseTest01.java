package com.computinglife.leetcode.test;

/**
 * Created by yliu on 8/1/16.
 */

import java.util.*;

public class NeteaseTest01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        while (in.hasNext()) {
            int input = in.nextInt();
            if (input <= 0) {
                continue;
            }
            if(!testInput(input)){
                System.out.println("N - N = 0000");
                continue;
            }
            int num = input;
            while (!set.contains(num)) {
                set.add(num);
                int[] res = convert(num);
                num = res[0] - res[1];
                if(set.contains(num)){
                    break;
                }
                System.out.printf("%04d - %04d = %04d\n", res[0], res[1], num);
            }
            set.clear();
        }
        return;
    }

    public static boolean testInput(int i){
        int[] test = new int[4];
        for(int j = 0; j < 4; j++){
            test[j] = i % 10;
            i /= 10;
        }
        boolean res = false;
        for(int j = 0; j < 3; j++){
            if(test[j] != test[j + 1]){
                res = true;
                break;
            }
        }
        return res;
    }

    public static int[] convert(int i) {
        int[] res = new int[2];
        ArrayList<Integer> list = new ArrayList<>();
        while (i != 0) {
            list.add(i % 10);
            i = i / 10;
        }
        Collections.sort(list);
        for (int tmp : list) {
            res[1] = res[1] * 10 + tmp;
        }
        Collections.reverse(list);
        for (int tmp : list) {
            res[0] = res[0] * 10 + tmp;
        }
        return res;
    }
}
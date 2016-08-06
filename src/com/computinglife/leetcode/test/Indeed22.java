package com.computinglife.leetcode.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by yliu on 7/2/16.
 */
public class Indeed22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String numLine = sc.nextLine();
        String[] numsStr = numLine.split(" ");
        int[] nums = new int[N + 1];
        //format input
        for (int i = 0; i < N; i++) {
            nums[i + 1] = Integer.parseInt(numsStr[i]);
        }
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (set.contains(i)) {
                continue;
            }
            set.add(i);
            int tmp = i;
            while (!set.contains(nums[tmp])) {
                set.add(nums[tmp]);
                tmp = nums[tmp];
            }
            count++;
        }
        System.out.println(count);
    }
}

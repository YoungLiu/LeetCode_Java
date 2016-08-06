package com.computinglife.leetcode.test;

import java.util.*;

/**
 * Created by yliu on 8/2/16.
 */
public class Wangyi03 {

    static List<List<Integer>> premutation = new ArrayList<>();

    private static void allPermutation(ArrayList<Integer> nums, int from, int to) {
        if (to <= 1) {
            return;
        }
        if (from == to) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <= to; i++) {
                list.add(nums.get(i));
            }
            premutation.add(list);
        } else {
            for (int j = from; j <= to; j++) {
                swap(nums, j, from);
                allPermutation(nums, from + 1, to);
                swap(nums, j, from);
            }
        }
    }

    private static void swap(ArrayList<Integer> nums, int front, int back) {
        int tmp = nums.get(front);
        nums.set(front, nums.get(back));
        nums.set(back, tmp);
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nk = sc.nextLine();
        String p = sc.nextLine();
        String[] nkarray = nk.split(" ");
        int n = Integer.parseInt(nkarray[0]);
        int k = Integer.parseInt(nkarray[1]);
        String[] parray = p.split(" ");
        int[] array = new int[parray.length];

        //set存放没有被去掉的数字
        Set<Integer> set = new HashSet<>();
        //list存放被去掉的数字
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < parray.length; i++) {
            array[i] = Integer.parseInt(parray[i]);
            if (array[i] != 0) {
                set.add(array[i]);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        if(list.size() == 0){
            // 没有去掉项
            System.out.println(0);
            return;
        }

        allPermutation(list, 0, list.size() - 1);
        int res = 0;
        for (List<Integer> tmp : premutation) {
            int num = 0;
            int count = 0;
            int[] test = new int[n];
            for (int i = 0; i < n; i++) {
                if (array[i] == 0) {
                    test[i] = tmp.get(num++);
                } else {
                    test[i] = array[i];
                }
            }
            //process the test array
            boolean flag = false;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (test[i] < test[j]) {
                        count++;
                    }
                    if (count > k) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (count == k) {
                res++;
            }
        }
        System.out.println(res);

    }
}

/*Given a list of non negative integers, arrange them such that they form the largest number.

        For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

        Note: The result may be very large, so you need to return a string instead of an integer.
        */

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by youngliu on 2/16/16.
 */
public class LargestNumber {
    public String largestNumberBack(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        int count = 0;
        for (int tmp : nums) {
            if (tmp == 0) {
                count++;
            }
        }
        if (count == nums.length) {
            return "0";
        }
        boolean exchange;
        for (int i = 1; i < nums.length; i++) {
            exchange = false;
            for (int j = nums.length - 1; j >= i; j--) {
                if (compare(nums[j], nums[j - 1])) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                    exchange = true;
                }
            }
            if (!exchange) {
                break;
            }
        }
        //遍历nums,连接
        String res = "";
        for (int tmp : nums) {
            res += tmp;
        }
        return res;
    }

    //定义比较规则
    private boolean compare(int a, int b) {
        Integer[] aArray = change(a);
        Integer[] bArray = change(b);
        int size = Math.min(aArray.length, bArray.length);
        for (int i = 0; i < size; i++) {
            if (aArray[i] > bArray[i]) {
                return true;
            } else if (aArray[i] < bArray[i]) {
                return false;
            }
        }
        //出现了前缀相同情况
        //如果完全
        if (aArray.length == bArray.length) {
            return false;
        }
        if (aArray.length > bArray.length) {
            for (int i = size; i < aArray.length; i++) {
                if (aArray[i] > aArray[i - size]) {
                    return true;
                } else if (aArray[i] < aArray[i - size]) {
                    return false;
                }
            }
            return false;
        } else {
            for (int i = size; i < bArray.length; i++) {
                if (bArray[i] > bArray[i - size]) {
                    return false;
                } else if (bArray[i] < bArray[i - size]) {
                    return true;
                }
            }
            return true;
        }
    }

    //将数字转换为单个数字０－９的数组
    private Integer[] change(int item) {
        List<Integer> res = new ArrayList<>();
        if (item == 0) {
            res.add(0);
            return (Integer[]) res.toArray(new Integer[res.size()]);
        }
        while (item != 0) {
            res.add(0, item % 10);
            item /= 10;
        }
        return (Integer[]) res.toArray(new Integer[res.size()]);
    }

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String leftRight = o1 + o2;
                String rightLeft = o2 + o1;
                return -leftRight.compareTo(rightLeft);
            }
        });

        StringBuilder res = new StringBuilder();
        for (String tmp : strs) {
            res.append(tmp);
        }

        while (res.charAt(0) == '0' && res.length() > 1) {
            res.deleteCharAt(0);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        LargestNumber test = new LargestNumber();
        int[] nums = {121, 12};
        System.out.println(test.largestNumber(nums));
    }
}

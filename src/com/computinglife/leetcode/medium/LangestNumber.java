package com.computinglife.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yliu on 7/13/16.
 */
public class LangestNumber {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        // write your code here
        if (num == null || num.length == 0){
            return "";
        }
        Integer[] nums = new Integer[num.length];
        for(int i = 0; i < num.length; i++){
            nums[i] = Integer.valueOf(num[i]);
        }
        Arrays.sort(nums, new NumberComparator());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    static class NumberComparator implements Comparator {
        public int compare(Object object1, Object object2) {
            int p1int = (int) object1;
            int p2int = (int) object2;
            String p1 = String.valueOf(p1int);
            String p2 = String.valueOf(p2int);
            char[] p1Array = p1.toCharArray();
            char[] p2Array = p2.toCharArray();
            int length = p1Array.length > p2Array.length ? p2Array.length : p1Array.length;
            for(int i = 0; i < length ;i++){
                if(p1Array[i] > p2Array[i]){
                    return -1;
                }else if(p1Array[i] < p2Array[i]){
                    return 1;
                } else {
                    continue;
                }
            }
            if(p1Array.length > p2Array.length){
                int tmpp1 = Integer.parseInt(p1.substring(p2Array.length));
                int tmpp2 = Integer.parseInt(p2);
                return compare(tmpp1, tmpp2);
            } else if(p1Array.length < p2Array.length){
                int tmpp1 = Integer.parseInt(p1);
                int tmpp2 = Integer.parseInt(p2.substring(p1Array.length));
                return compare(tmpp1,tmpp2);
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args){
        LangestNumber test = new LangestNumber();
        int[] num = {1,20,23,4,8};
        System.out.println(test.largestNumber(num));
    }

}

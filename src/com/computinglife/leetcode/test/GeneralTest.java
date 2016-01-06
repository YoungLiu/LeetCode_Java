package com.computinglife.leetcode.test;

/**
 * Created by youngliu on 12/25/15.
 */
public class GeneralTest {

    public static void main(String[] args) {
//        List<Integer> testList = new ArrayList<>();
//        String test = "liuyang";
//        System.out.println(test.substring(1, 3));
        int[] testArray = new int[]{9, 8, 7, 1, 2, 3, 4};
        int length = testArray.length;
        int i = 0;
        while (i < length - 1) {
            while (i + 1 < length && testArray[i + 1] < testArray[i])
                i++;
            System.out.println(i);
            i++;
        }
    }
}

package com.computinglife.leetcode.test;

/**
 * Created by youngliu on 2/27/16.
 */
public class DoubleAndInt {

    public static void main(String[] args) {
        Double d = 0.9999;
        int i = 1;
        d += i;
        System.out.println(d.getClass().getSimpleName());
    }
}

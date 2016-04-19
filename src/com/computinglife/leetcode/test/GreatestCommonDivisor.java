package com.computinglife.leetcode.test;

/**
 * Created by YanceyLiu on 4/18/2016.
 */
public class GreatestCommonDivisor {

    public static void main(String[] args) {
        int m = 3;
        int n = 10;
        int tmp;
        while (m % n != 0) {
            System.out.println("m is " + m);
            System.out.println("n is " + n);
            tmp = n;
            n = m % n;
            m = tmp;
        }
        System.out.println(n);
    }
}

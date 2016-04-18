package com.computinglife.leetcode.test;

/**
 * Created by youngliu on 2/27/16.
 */
public class ArgumentsTest {
    //string是final类型，改变后，会使object地址改变
    private void change(String s) {
        s = "liuyang";
    }

    public static void main(String[] args) {
        String origin = "ict";
        ArgumentsTest test = new ArgumentsTest();
        test.change(origin);
        System.out.println(origin);
    }
}

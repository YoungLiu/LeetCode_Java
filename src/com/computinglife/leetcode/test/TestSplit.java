package com.computinglife.leetcode.test;

/**
 * Created by youngliu on 1/29/16.
 */
public class TestSplit {

    public static void main(String[] args) {
        //String test = "liu|yang";
        //String[] testRes = test.split("\\|");     //字符串分隔符，| 不能随便写，这个在前面要加反斜杠

        String test = "             ";
        test = test.trim();
        String[] testRes = test.split(" ");
        System.out.println(testRes.length);
        for (String tmp : testRes) {
            System.out.println("--->" + tmp + "<---");
        }
    }
}

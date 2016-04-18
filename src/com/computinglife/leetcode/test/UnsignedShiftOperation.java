package com.computinglife.leetcode.test;

/**
 * Created by YanceyLiu on 4/11/2016.
 */
public class UnsignedShiftOperation {
    public static void main(String[] args){
        int var= 8;
        printInfo(var);
        var = var << 1;
        printInfo(var);
    }

    private static void printInfo(int num){
        System.out.println(Integer.toBinaryString(num));
    }
}

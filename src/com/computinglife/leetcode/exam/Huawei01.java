package com.computinglife.leetcode.exam;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by yliu on 8/5/16.
 */
public class Huawei01 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        BigInteger ans = BigInteger.valueOf(1);

        String s = cin.next();
        BigInteger n = new BigInteger(s);
        BigInteger temp = new BigInteger(s);
        //System.out.println("temp = " + temp);
        temp = temp.multiply(temp.subtract(new BigInteger("1")));
        //System.out.println("temp = " + temp);
        temp = temp.divide(new BigInteger("2"));
        //System.out.println("temp = " + temp);
        ans = ans.add(temp);
        temp = temp.multiply(n.subtract(new BigInteger("2")));
        temp = temp.multiply(n.subtract(new BigInteger("3")));
        temp = temp.divide(new BigInteger("12"));
        ans = ans.add(temp);
        System.out.println(ans.subtract(n));

    }
}

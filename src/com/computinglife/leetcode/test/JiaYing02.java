package com.computinglife.leetcode.test;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by yliu on 8/6/16.
 */
public class JiaYing02 {

    static BigInteger count = new BigInteger("0");
    static BigInteger max = new BigInteger("100000");
    static BigInteger prime = new BigInteger("1000000007");
    static BigInteger four = new BigInteger("4");
    static BigInteger eight = new BigInteger("8");
    static BigInteger three = new BigInteger("3");
    static BigInteger seven = new BigInteger("7");

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        BigInteger position = new BigInteger(input);

        search(position);

    }

    public static void search(BigInteger pos){
        if(count.compareTo(max) > 1){
            return;
        }
        if(pos.mod(prime).equals(new BigInteger("0"))){
            return;
        }
        count.add(new BigInteger("1"));
        BigInteger one = pos.multiply(four).add(three);
        search(one);

        BigInteger two = pos.multiply(eight).add(seven);
    }
}

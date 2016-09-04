package com.computinglife.leetcode.utils;

/**
 * Created by yliu on 8/24/16.
 */
public class GenerateRandom {
    private int m;
    private int n;

    //this a random function which from 1 to n comes from random_m
    public int random_n(){
        int val = 0;
        int t = 0; //t = m * m
        do{
            val = m * (random_m() -1) + random_m();
        }while (val > t);
        return val;
    }

    // just mock a random function which from 1 to m
    public int random_m(){
        return 0;
    }
}

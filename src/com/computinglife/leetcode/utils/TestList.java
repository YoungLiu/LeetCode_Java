package com.computinglife.leetcode.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yliu on 9/5/16.
 */
public class TestList {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(0, 1);
        list.add(0, 2);
        list.add(0, 3);
        for(int tmp : list){
            System.out.println(tmp);
        }
    }
}

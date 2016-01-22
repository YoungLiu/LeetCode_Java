package com.computinglife.leetcode.test;

import java.util.HashMap;

/**
 * Created by youngliu on 1/22/16.
 */
public class HashMapToArray {

    public static void main(String[] args){
        HashMap<Integer, String> m = new HashMap<Integer, String>();
        m.put(1, "one");
        m.put(2, "two");
        m.put(3, "three");
        //Object o[] = m.values().toArray();   //类型不精确但是可以将哈希表变成对象数组
        Integer[] o = m.keySet().toArray(new Integer[0]);//这样就可以将HashMap转换成字符串数组了,使用map的keySet或者是tade
        for (int i = 0; i < o.length; i++) {
            System.out.println(o[i]);
        }
    }
}

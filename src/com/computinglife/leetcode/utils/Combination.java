package com.computinglife.leetcode.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yliu on 8/10/16.
 */
public class Combination {

    // 位图法求全组合
    public List<String> combination(char[] chars) {
        List<String> res = new ArrayList<>();
        if (chars == null || chars.length == 0) {
            return res;
        }
        int len = chars.length;
        int max = 1 << len;
        for (int i = 1; i < max; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                if((i & (1 << j)) != 0){
                    sb.append(chars[j]);
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args){
        Combination test = new Combination();
        char[] chars = {'l', 'i', 'u'};
        List<String> res = test.combination(chars);
        for(String tmp : res){
            System.out.printf("%s ", tmp);
        }
    }
}

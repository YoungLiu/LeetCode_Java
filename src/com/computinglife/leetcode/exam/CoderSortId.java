package com.computinglife.leetcode.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yliu on 9/5/16.
 */
public class CoderSortId {
    public List<Integer> sortId(int n) {
        //from 1 to n
        List<Integer> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }
        Collections.sort(res, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                List<Integer> o1l = new ArrayList<Integer>();
                List<Integer> o2l = new ArrayList<Integer>();
                while (o1 != 0) {
                    o1l.add(0, o1 % 10);
                    o1 /= 10;
                }
                while (o2 != 0) {
                    o2l.add(0, o2 % 10);
                    o2 /= 10;
                }
                int l1 = 0, l2 = 0;
                while (l1 < o1l.size() && l2 < o2l.size()) {
                    if(o1l.get(l1) > o2l.get(l2)){
                        return 1;
                    } else if(o1l.get(l1) < o2l.get(l2)) {
                        return -1;
                    } else {
                        l1++;
                        l2++;
                    }
                }
                if(o1l.size() > o2l.size()){
                    return 1;
                } else if(o1l.size() < o2l.size()){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        return res;
    }

    public static void main(String[] args){
        CoderSortId test = new CoderSortId();
        List<Integer> res = test.sortId(11);
        for(int item : res){
            System.out.println(item);
        }
    }
}

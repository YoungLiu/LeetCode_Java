//Given an index k, return the kth row of the Pascal's triangle.
//
//        For example, given k = 3,
//        Return [1,3,3,1].
//
//        Note:
//        Could you optimize your algorithm to use only O(k) extra space?

package com.computinglife.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youngliu on 9/28/15.
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ori = new ArrayList<>();
        ori.add(0);
        ori.add(1);
        ori.add(0);
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            for (int j = 0; j < ori.size(); j++) {
                if (j == 0) {
                    tmp.add(0);
                }
                if (j == ori.size() - 1) {
                    tmp.add(ori.get(j));
                } else {
                    tmp.add(ori.get(j) + ori.get(j + 1));
                }
            }
            ori.removeAll(ori);
            ori.addAll(tmp);
            tmp.removeAll(tmp);
        }
        return ori.subList(1, ori.size() - 1);

    }

    public static void main(String[] args) {
        PascalsTriangleII test = new PascalsTriangleII();
        System.out.println(test.getRow(2));

    }
}

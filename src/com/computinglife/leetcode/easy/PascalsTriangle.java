//Given numRows, generate the first numRows of Pascal's triangle.
//
//        For example, given numRows = 5,
//        Return
//
//        [
//              [1],
//             [1,1],
//            [1,2,1],
//           [1,3,3,1],
//          [1,4,6,4,1]
//        ]

package com.computinglife.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Young on 2015/10/2.
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> ori = new ArrayList<>();
        ori.add(0);
        ori.add(1);
        ori.add(0);
        List<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
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
            List<Integer> tmp2 = new ArrayList<>();
            for (int m = 1; m < ori.size() - 1; m++) {
                tmp2.add(ori.get(m));
            }
            ret.add(tmp2);
            ori.removeAll(ori);
            ori.addAll(tmp);
            tmp.removeAll(tmp);
        }
        return ret;
    }

    public static void main(String[] args) {
        PascalsTriangle test = new PascalsTriangle();
        System.out.println(test.generate(5).toString());
    }
}

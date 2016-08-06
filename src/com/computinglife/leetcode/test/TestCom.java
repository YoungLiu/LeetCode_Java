//package com.computinglife.leetcode.test;
//
///**
// * Created by yliu on 7/2/16.
// */
//public class TestCom {
//
//    public static void main(String[] args){
//        int[] nums = {1,2,3};
//        int[] ret =
//
//    }
//
//    /**
//     * 组合问题： 输出从数组a的n个元素中选出m个元素的组合
//     *
//     * @param a 给定数组
//     * @param b 组合结果  (b中存放的是元素在a中的编号)
//     * @param n
//     * @param m
//     * @param M 常量=m 记录a中元素个数
//     *          <p>
//     *          思路：1.从n个元素中选出序号最大的数，然后在剩下的(n-1)个元素中选(m-1)个
//     *          当m=1时，倒序输出数组b；
//     *          2.从n个元素中选出编号次小的数，重复第1步。
//     */
//    public static void comb(int[] a, int[] b, int n, int m, final int M) {
//        for (int i = n; i >= m; i--) {
//            b[m - 1] = a[i - 1];
//            if (m > 1) {
//                comb(a, b, i - 1, m - 1, M);
//            }
//        }
//    }
//}

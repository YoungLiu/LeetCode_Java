/*Implement int sqrt(int x).

        Compute and return the square root of x.*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 12/17/15.
 */
public class SqrtX {
    //二分查找效率不满足时间效率要求,而且有溢出问题
    public int mySqrtBack(int x) {
        long start = 0;
        long end = x / 2 + 1;
        while (start <= end) {
            long mid = (start + end) / 2;
            long sqrt = mid * mid;
            if (sqrt == x) {
                return Integer.parseInt(mid + "");
            } else if (sqrt < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return Integer.parseInt(end + "");
    }

    //牛顿迭代法,效率有很大幅度提升
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        double last = 0;
        double res = 1;
        while (res != last) {
            last = res;
            res = (res + x / res) / 2;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        SqrtX test = new SqrtX();
        long start = System.currentTimeMillis();
        System.out.println(test.mySqrt(4));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//        Note:
//        You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
//        The number of elements initialized in nums1 and nums2 are m and n respectively.

package com.computinglife.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Young on 2015/10/6.
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        List<Integer> numList = new ArrayList<>();
        for(int i = 0;i<m;i++){
            numList.add(nums1[i]);
        }
        for(int tmp:nums2){
            numList.add(tmp);
        }
        Collections.sort(numList);
        for(int i = 0;i<numList.size();i++){
            nums1[i] = numList.get(i);
        }
    }

}

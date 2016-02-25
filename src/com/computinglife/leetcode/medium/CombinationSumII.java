//Given a collection of candidate numbers (C) and a target number (T), 
//find all unique combinations in C where the candidate numbers sums to T.
//
//Each number in C may only be used once in the combination.
//
//Note:
//All numbers (including target) will be positive integers.
//Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//The solution set must not contain duplicate combinations.
//For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
//A solution set is: 
//[1, 7] 
//[1, 2, 5] 
//[2, 6] 
//[1, 1, 6] 

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Boolean[] isVisited = new Boolean[candidates.length];
        Arrays.fill(isVisited, false);
        combination(candidates, new ArrayList<Integer>(), target, 0, 0, isVisited);
        return res;
    }

    public void combination(int[] candidates, List<Integer> list, int target, int sum, int max, Boolean[] isVisited) {
        if (sum > target) {
            return;
        }
        if (target == sum) {
            res.add(new ArrayList<>(list));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < candidates.length; i++) {
            if (!isVisited[i] && candidates[i] >= max && !set.contains(candidates[i])) {
                set.add(candidates[i]);
                isVisited[i] = true;
                list.add(candidates[i]);
                combination(candidates, list, target, sum + candidates[i], candidates[i], isVisited);
                isVisited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumII test = new CombinationSumII();
        int[] nums = {1};
        test.combinationSum2(nums, 1);
        System.out.println(test.res);
    }
}

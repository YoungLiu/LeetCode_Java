//Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//The same repeated number may be chosen from C unlimited number of times.
//
//Note:
//All numbers (including target) will be positive integers.
//Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//The solution set must not contain duplicate combinations.
//For example, given candidate set 2,3,6,7 and target 7, 
//A solution set is: 
//[7]
//[2, 2, 3]

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<>();
		combination(candidates, res, new ArrayList<>(), target, 0);
		return res;
	}

	public void combination(int[] candidates, List<List<Integer>> res, List<Integer> list, int target, int start) {
		if (target == 0) {
			res.add(list);
			return;
		}
		for (; start < candidates.length; start++) {
			if (target - candidates[start] < 0) {
				break;
			}
			List<Integer> tmp = new ArrayList<>(list);
			tmp.add(candidates[start]);
			combination(candidates, res, tmp, target - candidates[start], start);
		}
	}
}

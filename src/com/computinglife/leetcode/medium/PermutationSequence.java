//The set [1,2,3,…,n] contains a total of n! unique permutations.
//
//By listing and labeling all of the permutations in order,
//We get the following sequence (ie, for n = 3):
//
//"123"
//"132"
//"213"
//"231"
//"312"
//"321"
//Given n and k, return the kth permutation sequence.
//
//Note: Given n will be between 1 and 9 inclusive.

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		if (k <= 0 || k > factorial(n)) {
			return null;
		}
		boolean[] isVisited = new boolean[n];
		Arrays.fill(isVisited, false);
		int original = 0;
		int peek = n;
		int sum = sum(n);
		int tmp;
		StringBuilder stringBuilder = new StringBuilder();
		while (n > 1) {
			// 此处应该取天花板函数,乘1.0为了将整形自动转为浮点型进行天花板函数运算
			if (k == factorial(n)) {
				tmp = peek;
				--n;
			} else {
				tmp = (int) Math.ceil(k * 1.0 / factorial(--n));
			}
			while (isVisited[tmp - 1]) {
				if ((tmp - 1) == peek - 1) {
					// 找到没有被用的且最大的元素
					while (isVisited[tmp - 1]) {
						tmp--;
					}
				} else {
					tmp++;
				}
			}
			isVisited[tmp - 1] = true;
			stringBuilder.append(tmp);
			k = k % factorial(n) == 0 ? factorial(n) : k % factorial(n);
			original += tmp;
		}
		stringBuilder.append(sum - original);
		return stringBuilder.toString();
	}

	public int sum(int n) {
		int res = 0;
		while (n > 0) {
			res += n--;
		}
		return res;
	}

	public int factorial(int n) {
		int res = 1;
		while (n > 0) {
			res *= n;
			n--;
		}
		return res;
	}

	public String getPermutation2(int n, int k) {
		StringBuilder ret = new StringBuilder();
		// 存放按位增长的阶乘信息,最高位顶级不用存储
		int[] factorial = new int[n];
		factorial[0] = 1;
		for (int i = 1; i < n; i++) {
			factorial[i] = factorial[i - 1] * i;
		}
		// 存放我们需要的数字
		List<Character> nums = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nums.add(i, (char) ((i + 1) + '0'));
		}
		k--;// 之所以减一，是为了后面取nums中的数字方便
		for (int i = n; i >= 1; i--) {
			int index = k / (factorial[i - 1]);
			k %= (factorial[i - 1]);
			ret.append(nums.get(index));
			nums.remove(index);
		}
		return ret.toString();
	}

	public static void main(String[] args) {
		PermutationSequence test = new PermutationSequence();
		Long start = System.currentTimeMillis();
		System.out.println(test.getPermutation2(8, 8590));
		Long end = System.currentTimeMillis();
		System.err.println(end - start);
	}
}

//Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
//n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
//Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
//Note: You may not slant the container.
//此题嵌套遍历的方法一定是不行的，考虑计算复杂度

package com.computinglife.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class ContainerWithMostWater {
	// 普通方法
	public int maxArea2(int[] height) {
		int maxVolume = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = 0; j < height.length; j++) {
				if (Math.abs(i - j) * Math.min(height[i], height[j]) > maxVolume) {
					maxVolume = Math.abs(i - j) * Math.min(height[i], height[j]);
				}
			}
		}
		return maxVolume;
	}

	// 低效方法(hashmap遍历反而效率会变低)
	public int maxArea3(int[] height) {
		int maxVolume = 0;
		Map<String, Boolean> check = new HashMap<>();
		for (int i = 0; i < height.length; i++) {
			for (int j = 0; j < height.length; j++) {
				if (check.containsKey(i + "-" + j) || check.containsKey(j + "-" + i)) {
					continue;
				} else {
					maxVolume = Math.abs(i - j) * Math.min(height[i], height[j]) > maxVolume
							? Math.abs(i - j) * Math.min(height[i], height[j]) : maxVolume;
					check.put(i + "-" + j, true);
				}
			}
		}
		return maxVolume;
	}

	public int maxArea(int[] height) {
		int maxVolume = 0;
		int left = 0;
		int right = height.length - 1;

		while (left < right) {
			maxVolume = Math.max(Math.min(height[left], height[right]) * (right - left), maxVolume);
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxVolume;
	}

	public static void main(String[] args) {
		ContainerWithMostWater test = new ContainerWithMostWater();
		int[] height = new int[] { 2, 6, 3, 9, 7, 4, 2, 5, 1, 5, 8, 4, 2, 8, 2, 5, 8, 0, 2, 1, 5, 8, 9, 4, 3 };
		Long start = System.currentTimeMillis();
		System.out.println(test.maxArea2(height));
		Long end = System.currentTimeMillis();
		System.err.println(end - start);
	}

}

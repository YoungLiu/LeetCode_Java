//Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
//For example,
//Given n = 3,
//
//You should return the following matrix:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]

package com.computinglife.leetcode.medium;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int startX = 0;
		int startY = 0;
		int endX = n - 1;
		int endY = n - 1;
		int[][] res = new int[n][n];
		int count = 1;
		while (true) {
			for (int index = startX; index <= endX; index++) {
				res[startY][index] = count++;
			}
			startY++;
			if (startY > endY) {
				break;
			}
			for (int index = startY; index <= endY; index++) {
				res[index][endX] = count++;
			}
			endX--;
			if (endX < startX) {
				break;
			}
			for (int index = endX; index >= startX; index--) {
				res[endY][index] = count++;
			}
			endY--;
			if (endY < startY) {
				break;
			}
			for (int index = endY; index >= startY; index--) {
				res[index][startX] = count++;
			}
			startX++;
			if (startX > endX) {
				break;
			}
		}
		return res;
	}
}

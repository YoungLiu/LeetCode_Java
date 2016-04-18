//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//For example,
//Given the following matrix:
//
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//You should return [1,2,3,6,9,8,7,4,5].

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return new ArrayList<>();
		}
		int startX = 0;
		int startY = 0;
		int endX = matrix[0].length - 1;
		int endY = matrix.length - 1;
		List<Integer> res = new ArrayList<>();
		while (true) {
			for (int index = startX; index <= endX; index++) {
				res.add(matrix[startY][index]);
			}
			startY++;
			if (startY > endY) {
				break;
			}
			for (int index = startY; index <= endY; index++) {
				res.add(matrix[index][endX]);
			}
			endX--;
			if (endX < startX) {
				break;
			}
			for (int index = endX; index >= startX; index--) {
				res.add(matrix[endY][index]);
			}
			endY--;
			if (endY < startY) {
				break;
			}
			for (int index = endY; index >= startY; index--) {
				res.add(matrix[index][startX]);
			}
			startX++;
			if (startX > endX) {
				break;
			}
		}
		return res;
	}
}

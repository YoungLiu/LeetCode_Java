//Find the total area covered by two rectilinear rectangles in a 2D plane.
//
//Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
//Assume that the total area is never beyond the maximum possible value of int.
//			  /|\
//			   |
//	----(C,D)  |     ----------(G,H)
//  |	  |	   |    |            |
//------------------------------------>
//  | 	  |    |    |            |
//(A,B)----	   |  (E,F)----------
//			   |
//			   |

package com.computinglife.leetcode.easy;

public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		// 首先根据矩形中心判断是否发生了重合
		int lengthX = C - A;
		int widthX = D - B;
		int lengthY = G - E;
		int widthY = H - F;
		double[] x = { lengthX / 2d + A, widthX / 2d + B };
		double[] y = { lengthY / 2d + E, widthY / 2d + F };
		// double maxDis = Math
		// .sqrt(Math.pow((widthX / 2d + widthY / 2d), 2) + Math.pow((lengthX /
		// 2d + lengthY / 2d), 2));
		// double factDis = Math.sqrt(Math.pow(x[0] - y[0], 2) + Math.pow(x[1] -
		// y[1], 2));
		if (x[0] == y[0] && x[1] == y[1] && lengthX == lengthY && widthX == widthY) {
			return lengthX * widthX;
		}
		// 判断是否相交性
		if (Math.abs(x[0] - y[0]) > lengthX / 2d + lengthY / 2d || Math.abs(x[1] - y[1]) > widthX / 2d + widthY / 2d) {
			// 无重合,面积值相加
			int res = lengthX * widthX + lengthY * widthY;
			return res;
		} else {
			// 存在重合
			int total = lengthX * widthX + lengthY * widthY;
			// 减去重合部分
			// 求重合部分宽度
			double widthSuperposition;
			if (x[1] > y[1]) {
				if ((x[1] + widthX / 2d) >= (y[1] + widthY / 2d)) {
					// 剪切重合
					widthSuperposition = (widthX / 2d + widthY / 2d) - Math.abs(x[1] - y[1]);
				} else {
					// 覆盖重合
					widthSuperposition = widthX;
				}
			} else if (x[1] == y[1]) {
				if (widthX > widthY) {
					widthSuperposition = widthY;
				} else if (widthX == widthY) {
					widthSuperposition = widthX;
				} else {
					widthSuperposition = widthX;
				}
			} else {
				if ((y[1] + widthY / 2d) >= (x[1] + widthX / 2d)) {
					// 剪切重合
					widthSuperposition = (widthX / 2d + widthY / 2d) - Math.abs(x[1] - y[1]);
				} else {
					// 覆盖重合
					widthSuperposition = widthY;
				}
			}
			// 求重合部分长度
			double lengthSuperposition;
			if (x[0] > y[0]) {
				if ((x[0] + lengthX / 2d) >= (y[0] + lengthY / 2d)) {
					// 剪切重合
					lengthSuperposition = (lengthX / 2d + lengthY / 2d) - Math.abs(x[0] - y[0]);
				} else {
					// 覆盖重合
					lengthSuperposition = lengthX;
				}
			} else if (x[0] == y[0]) {
				if (lengthX > lengthY) {
					lengthSuperposition = lengthY;
				} else if (lengthX == lengthY) {
					lengthSuperposition = lengthX;
				} else {
					lengthSuperposition = lengthX;
				}

			} else {
				if ((y[0] + lengthY / 2d) >= (x[0] + lengthX / 2d)) {
					// 剪切重合
					lengthSuperposition = (lengthX / 2d + lengthY / 2d) - Math.abs(x[0] - y[0]);
				} else {
					// 覆盖重合
					lengthSuperposition = lengthY;
				}
			}
			double res = total - widthSuperposition * lengthSuperposition;
			return (int) res;
		}
	}

	public int computeArea2(int A, int B, int C, int D, int E, int F, int G, int H) {
		int sum = (C - A) * (D - B) + (G - E) * (H - F);
		if (C <= E || A >= G || D <= F || B >= H) {
			return sum;
		}
		int comm = (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
		return sum - comm;
	}

	public static void main(String[] args) {
		RectangleArea test = new RectangleArea();
		System.out.println(test.computeArea(1, 2, 5, 6, 3, 1, 8, 4));
	}
}

//Invert a binary tree.
//
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//to
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
//Trivia:
//This problem was inspired by this original tweet by Max Howell:
//Google: 90% of our engineers use the software you wrote (Homebrew), 
//but you can’t invert a binary tree on a whiteboard so fuck off.

package com.computinglife.leetcode;

public class InvertBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		if (root.left == null && root.right == null) {
			return root;
		}
		TreeNode tmp = null;
		root.right = invertTree(root.right);
		root.left = invertTree(root.left);
		tmp = root.right;
		root.right = root.left;
		root.left = tmp;
		return root;
	}

}

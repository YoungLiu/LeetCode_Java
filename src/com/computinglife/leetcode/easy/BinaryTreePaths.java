//Given a binary tree, return all root-to-leaf paths.
//
//For example, given the following binary tree:
//
//   1
// /   \
//2     3
// \
//  5
//All root-to-leaf paths are:
//
//["1->2->5", "1->3"]

package com.computinglife.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			super();
			this.val = val;
		}
	}

	private List<String> result = new ArrayList<String>();

	public List<String> binaryTreePaths(TreeNode root) {
		dfs(root, "");
		return result;
	}

	public void dfs(TreeNode node, String path) {
		if (node == null) {
			return;
		}
		path += node.val;
		if (isLeafNode(node)) {
			result.add(path);
		}
		path += "- >";
		dfs(node.left, path);
		dfs(node.right, path);
	}

	public boolean isLeafNode(TreeNode node) {
		return node.left == null && node.right == null;
	}

}

//Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
//
//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between 
//two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
//
//        _______6______
//       /              \
//    ___2__          ___8__
//   /      \        /      \
//   0      _4       7       9
//         /  \
//         3   5
//For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, 
//since a node can be a descendant of itself according to the LCA definition.

package com.computinglife.leetcode.easy;

public class LowestCommonAncestorBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// 检查边界条件
		if (root == null || p == null || q == null) {
			if (root == null) {
				return null;
			}
			if (p == null && q == null) {
				return root;
			}
			return p == null ? q : p;
		}

		int bigger = p.val > q.val ? p.val : q.val;
		int smaller = q.val < p.val ? q.val : p.val;

		if (root.val > bigger) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (root.val < smaller) {
			return lowestCommonAncestor(root.right, p, q);
		} else if (smaller < root.val && root.val < bigger) {
			return root;
		} else {
			return root;
		}
	}

}

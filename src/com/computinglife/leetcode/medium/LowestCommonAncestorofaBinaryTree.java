/*Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

        According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
        between two nodes v and w as the lowest node in T that has both v and w as descendants
        (where we allow a node to be a descendant of itself).”

                  _______3______
                 /              \
              ___5__          ___1__
             /      \        /      \
             6       2       0       8
                    /  \
                    7   4
        For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
        Another example is LCA of nodes 5 and 4 is 5,
        since a node can be a descendant of itself according to the LCA definition.*/

package com.computinglife.leetcode.medium;

/**
 * Created by YanceyLiu on 3/1/2016.
 */
public class LowestCommonAncestorofaBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Entity {
        int count;
        TreeNode node;

        public Entity(int count, TreeNode node) {
            this.count = count;
            this.node = node;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lcaHelper(root, p, q).node;
    }

    public Entity lcaHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Entity(0, null);
        }
        Entity left = lcaHelper(root.left, p, q);
        if (left.count == 2) {
            return left;
        }

        Entity right = lcaHelper(root.right, p, q);
        if (right.count == 2) {
            return right;
        }

        int numTotal = left.count + right.count;
        if (root == p || root == q) {
            numTotal++;
        }

        return new Entity(numTotal, root);
    }

    public int countMatchs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        int matchs = countMatchs(root.left, p, q) + countMatchs(root.right, p, q);
        if (root == p || root == q) {
            return matchs + 1;
        } else {
            return matchs;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (root == q || root == p) {
            return root;
        }
        int totalMatchs = countMatchs(root.left, p, q);
        if (totalMatchs == 2) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (totalMatchs == 1) {
            return root;
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}

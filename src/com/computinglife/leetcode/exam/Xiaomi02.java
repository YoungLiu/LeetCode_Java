package com.computinglife.leetcode.exam;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by yliu on 9/23/16.
 */
public class Xiaomi02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            TreeNode root = null;
            boolean flag = true;
            HashMap<Integer, TreeNode> map = new HashMap<>();
            while (num-- > 1) {
                int parent = sc.nextInt();
                int child = sc.nextInt();
                if (flag) {
                    root = new TreeNode(parent);
                    map.put(parent, root);
                    root.left = new TreeNode(child);
                    map.put(child, root.left);
                    flag = false;
                } else {
                    TreeNode par = null;
                    if (map.containsKey(parent)) {
                        par = map.get(parent);
                        par.right = new TreeNode(child);
                        map.put(child, par.right);
                    } else {
                        par = new TreeNode(parent);
                        map.put(parent, par);
                        par.left = new TreeNode(child);
                        map.put(child, par.left);
                    }
                }
            }
            int high = getDepth(root);
            System.out.println(high);
        }
    }

    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        int currentLevelNodes = 1;
        int nextLevelNodes = 0;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            currentLevelNodes--;
            if (cur.left != null) {
                queue.add(cur.left);
                nextLevelNodes++;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextLevelNodes++;
            }

            if (currentLevelNodes == 0) {
                depth++;
                currentLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
            }
        }

        return depth;
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.val = value;
        this.left = null;
        this.right = null;
    }
}


/*One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node,
        we record the node's value. If it is a null node, we record using a sentinel value such as #.

                 _9_
                /   \
               3     2
              / \   / \
             4   1  #  6
            / \ / \   / \
            # # # #   # #
        For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#",
        where # represents a null node.

        Given a string of comma separated values, verify whether it is a correct preorder traversal serialization
        of a binary tree. Find an algorithm without reconstructing the tree.

        Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

        You may assume that the input format is always valid, for example it could never contain two consecutive commas
        such as "1,,3".

        Example 1:
        "9,3,4,#,#,1,#,#,2,#,6,#,#"
        Return true

        Example 2:
        "1,#"
        Return false

        Example 3:
        "9,#,#,1"
        Return false*/

package com.computinglife.leetcode.medium;

import java.util.Stack;

/**
 * Created by YanceyLiu on 5/2/2016.
 */
public class VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null) {
            return true;
        }
        String[] array = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (stack.isEmpty()) {
                stack.push(array[i]);
            } else {
                String tmp = array[i];
                if (tmp.equals("#")) {
                    while (!stack.isEmpty() && stack.peek().equals("#")) {
                        if (tmp.equals("#")) {
                            if (stack.size() > 1) {
                                stack.pop();
                                stack.pop();
                            }else{
                                return false;
                            }
                        } else {
                            stack.push(tmp);
                        }
                    }
                    stack.push(tmp);
                } else
                    stack.push(tmp);
            }
        }
        if (stack.size() == 1 && stack.peek().equals("#")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        VerifyPreorderSerializationofaBinaryTree test = new VerifyPreorderSerializationofaBinaryTree();
        String preorder = "1,#,#,#,#";
        System.out.println(test.isValidSerialization(preorder));
    }
}

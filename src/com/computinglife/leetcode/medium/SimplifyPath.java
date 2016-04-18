/*Given an absolute path for a file (Unix-style), simplify it.

        For example,
        path = "/home/", => "/home"
        path = "/a/./b/../../c/", => "/c"

        Corner Cases:
        Did you consider the case where path = "/../"?
        In this case, you should return "/".
        Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
        In this case, you should ignore redundant slashes and return "/home/foo".*/

package com.computinglife.leetcode.medium;

import java.util.Stack;

/**
 * Created by youngliu on 12/17/15.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        //存放路径信息，/占一位，一个文件夹名占一位
        Stack<String> stack = new Stack<>();
        char[] paths = path.toCharArray();
        for (int i = 0; i < paths.length; i++) {
            if (i < paths.length - 2 && paths[i] == '.' && paths[i + 1] == '.' && paths[i + 2] == '/') {
                // ..的情况(防止栈空的情况出现)
                int k = 3;
                while (!stack.isEmpty() && k-- > 0) {
                    stack.pop();
                }
                i++;
                continue;
            } else if (i < path.length() - 1 && paths[i] == '.' && paths[i + 1] == '/') {
                // ./的情况
                i++;
                continue;
            } else if (paths[i] == '/') {
                // /的情况 需提前判断栈顶是否为/,如果是则不压栈
                if (!stack.isEmpty() && !stack.peek().equals("/")) {
                    stack.push("/");
                }
                if (stack.isEmpty()) {
                    stack.push("/");
                }
            } else {
                //字符串作为目录名称需要压栈的情况
                StringBuilder stringFolder = new StringBuilder();
                while (i < paths.length && paths[i] != '/') {
                    stringFolder.append(paths[i]);
                    i++;
                }
                //还原i的位置
                i--;
                stack.push(stringFolder.toString());
            }
        }
        //将stack中的内容还原成路径名称
        if(!stack.isEmpty() && stack.peek().equals("..")){
            int k = 3;
            while (!stack.isEmpty() && k-- > 0) {
                stack.pop();
            }
        }
        if (!stack.isEmpty() && stack.peek().equals(".")) {
            stack.pop();
        }
        while (!stack.isEmpty() && stack.peek().equals("/")) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            return "/";
        }
        Stack<String> res = new Stack<>();
        while (!stack.isEmpty()) {
            res.push(stack.pop());
        }
        StringBuilder result = new StringBuilder();
        while (!res.isEmpty()) {
            result.append(res.pop());
        }
        return result.toString();
    }

    public static void main(String[] agr) {
        SimplifyPath test = new SimplifyPath();
        //System.out.println(test.simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
        System.out.println(test.simplifyPath("///eHx/.."));
    }
}

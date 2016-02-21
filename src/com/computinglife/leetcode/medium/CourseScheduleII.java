/*There are a total of n courses you have to take, labeled from 0 to n - 1.

        Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
        which is expressed as a pair: [0,1]

        Given the total number of courses and a list of prerequisite pairs,
        return the ordering of courses you should take to finish all courses.

        There may be multiple correct orders, you just need to return one of them.
        If it is impossible to finish all courses, return an empty array.

        For example:

        2, [[1,0]]
        There are a total of 2 courses to take. To take course 1 you should have finished course 0.
        So the correct course order is [0,1]

        4, [[1,0],[2,0],[3,1],[3,2]]
        There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
        Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3].
        Another correct ordering is[0,2,1,3].

        Note:
        The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
        Read more about how a graph is represented.

        click to show more hints.

        Hints:
        This problem is equivalent to finding the topological order in a directed graph.
        If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
        Topological Sort via DFS - A great video tutorial (21 minutes)
        on Coursera explaining the basic concepts of Topological Sort.
        Topological sort could also be done via BFS.*/

package com.computinglife.leetcode.medium;

import java.util.LinkedList;

/**
 * Created by youngliu on 2/21/16.
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            throw new IllegalArgumentException("illegal argument");
        }
        int len = prerequisites.length;
        if (len == 0) {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
        }
        int[] pCounter = new int[numCourses];
        for (int i = 0; i < len; i++) {
            pCounter[prerequisites[i][0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (pCounter[i] == 0) {
                queue.add(i);
            }
        }
        int numNoPre = queue.size();
        int[] res = new int[numCourses];
        int pointer = 0;
        while (!queue.isEmpty()) {
            int top = queue.poll();
            res[pointer++] = top;
            for (int i = 0; i < len; i++) {
                if (prerequisites[i][1] == top) {
                    pCounter[prerequisites[i][0]]--;
                    if (pCounter[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                        numNoPre++;
                    }
                }
            }
        }

        if (numNoPre == numCourses) {
            return res;
        } else {
            return new int[0];
        }
    }
}

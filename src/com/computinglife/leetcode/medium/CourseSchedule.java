/*There are a total of n courses you have to take, labeled from 0 to n - 1.

        Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

        Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

        For example:

        2, [[1,0]]
        There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

        2, [[1,0],[0,1]]
        There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

        Note:
        The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

        click to show more hints.

        Hints:
        This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
        Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
        Topological sort could also be done via BFS.*/

package com.computinglife.leetcode.medium;

import java.util.LinkedList;

/**
 * Created by youngliu on 2/20/16.
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            throw new IllegalArgumentException("illegal prerequisites sites");
        }
        if (numCourses == 0 || prerequisites.length == 0) {
            return true;
        }
        int len = prerequisites.length;
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
        while (!queue.isEmpty()) {
            int top = queue.poll();
            for (int i = 0; i < len; i++) {
                if (prerequisites[i][1] == top) {
                    pCounter[prerequisites[i][0]]--;
                    if (pCounter[prerequisites[i][0]] == 0) {
                        numNoPre++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return numNoPre == numCourses;
    }
}

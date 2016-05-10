/*For a undirected graph with tree characteristics, we can choose any node as the root.
The result graph is then a rooted tree. Among all possible rooted trees,
those with minimum height are called minimum height trees (MHTs). Given such a graph,
write a function to find all the MHTs and return a list of their root labels.

        Format
        The graph contains n nodes which are labeled from 0 to n - 1.
        You will be given the number n and a list of undirected edges (each edge is a pair of labels).

        You can assume that no duplicate edges will appear in edges. Since all edges are undirected,
        [0, 1] is the same as [1, 0] and thus will not appear together in edges.

        Example 1:

        Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

          0
          |
          1
         / \
        2   3
        return [1]

        Example 2:

        Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

        0  1  2
         \ | /
           3
           |
           4
           |
           5
        return [3, 4]

        Hint:

        How many MHTs can a graph have at most?
        Note:

        (1) According to the definition of tree on Wikipedia:
         “a tree is an undirected graph in which any two vertices are connected by exactly one path.
         In other words, any connected graph without simple cycles is a tree.”

        (2) The height of a rooted tree is the number of edges on the longest downward path
        between the root and a leaf.*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YanceyLiu on 5/8/2016.
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges == null || n < 0) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        int[] digree = new int[n];
        //init
        List<List<Integer>> tranEdges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> tmp = new ArrayList<>();
            tranEdges.add(tmp);
        }
        for (int i = 0; i < edges.length; i++) {
            digree[edges[i][0]]++;
            digree[edges[i][1]]++;

            tranEdges.get(edges[i][0]).add(edges[i][1]);
            tranEdges.get(edges[i][1]).add(edges[i][0]);
        }
        List<Integer> leaf = new ArrayList<>();
        for (int i = 0; i < digree.length; i++) {
            if (digree[i] == 1) {
                leaf.add(i);
            }
        }
        while (n > 2) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < leaf.size(); i++) {
                digree[leaf.get(i)] = 0;
                n--;
                for (int j = 0; j < tranEdges.get(leaf.get(i)).size(); j++) {
                    digree[tranEdges.get(leaf.get(i)).get(j)]--;
                    if (digree[tranEdges.get(leaf.get(i)).get(j)] == 1) {
                        tmp.add(tranEdges.get(leaf.get(i)).get(j));
                    }
                }
            }
            leaf = tmp;
        }
        return leaf;
    }

    public static void main(String[] args) {
        MinimumHeightTrees test = new MinimumHeightTrees();
        int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        System.out.println(test.findMinHeightTrees(6, edges));
    }
}

/*Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


        OJ's undirected graph serialization:
        Nodes are labeled uniquely.

        We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
        As an example, consider the serialized graph {0,1,2#1,2#2,2}.

        The graph has a total of three nodes, and therefore contains three parts as separated by #.

        First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
        Second node is labeled as 1. Connect node 1 to node 2.
        Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
        Visually, the graph looks like the following:

           1
          / \
         /   \
        0 --- 2
             / \
             \_/

             */

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by youngliu on 1/10/16.
 */
public class CloneGraph {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> trace = new HashMap<>();
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        trace.put(node, clone);
        cloneGraph(node, trace);
        return clone;
    }

    private void cloneGraph(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> trace) {
        for (int i = 0; i < node.neighbors.size(); i++) {
            UndirectedGraphNode cur = node.neighbors.get(i);
            if (!trace.containsKey(cur)) {
                UndirectedGraphNode copy = new UndirectedGraphNode(cur.label);
                trace.put(cur, copy);
                cloneGraph(cur, trace);
            }
            trace.get(node).neighbors.add(trace.get(cur));
        }
    }

}

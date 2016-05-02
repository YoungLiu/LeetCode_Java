/*Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
        reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK.
        Thus, the itinerary must begin with JFK.

        Note:
        If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order
        when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
        All airports are represented by three capital letters (IATA code).
        You may assume all tickets form at least one valid itinerary.
        Example 1:
        tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
        Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
        Example 2:
        tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
        Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by YanceyLiu on 5/2/2016.
 */
public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null) {
            return null;
        }
        HashMap<String, TreeMap<String, Integer>> m = new HashMap<>();
        //init
        for (String[] tmp : tickets) {
            if (m.containsKey(tmp[0])) {
                if (m.get(tmp[0]).containsKey(tmp[1])) {
                    m.get(tmp[0]).put(tmp[1], m.get(tmp[0]).get(tmp[1]) + 1);
                } else {
                    m.get(tmp[0]).put(tmp[1], 1);
                }
            } else {
                TreeMap<String, Integer> neighbor = new TreeMap<>();
                neighbor.put(tmp[1], 1);
                m.put(tmp[0], neighbor);
            }
        }
        String start = "JFK";
        List<String> res = new ArrayList<>();
        res.add(start);
        dfs(start, res, tickets.length + 1, m);
        return res;
    }

    public boolean dfs(String start, List<String> res, int size, HashMap<String, TreeMap<String, Integer>> m) {
        if (res.size() == size) {
            return true;
        }
        if (m.containsKey(start)) {
            for (String to : m.get(start).keySet()) {
                if (m.get(start).get(to) != 0) {
                    m.get(start).put(to, m.get(start).get(to) - 1);
                    res.add(to);
                    if (dfs(to, res, size, m)) {
                        return true;
                    }
                    res.remove(res.size() - 1);
                    m.get(start).put(to, m.get(start).get(to) + 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] tickets = {{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}};
        ReconstructItinerary test = new ReconstructItinerary();
        List<String> res = test.findItinerary(tickets);
        for (String tmp : res) {
            System.out.println(tmp);
        }
    }
}

package com.computinglife.leetcode.exam;

import java.util.*;

/**
 * Created by yliu on 9/22/16.
 */
public class YouDao001 {
    private static double xc, yc;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] buy = new int[n];
            for (int i = 0; i < n; i++) {
                buy[i] = sc.nextInt();
            }
            xc = Math.ceil(k / 2);
            yc = xc;
            int[][] seat = new int[k][k];
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for(int i = 1; i <=k; i++){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(k);
                map.put(i, list);
            }
            for (int count : buy) {
                int row = (int) xc;
                int step = 0;
                while(step < k / 2) {
                    int key1 = row - step;
                    int key2 = row + step;
                    // check key1
                    ArrayList<Integer> list1 = map.get(key1);
                    Collections.sort(list1);
                    for(int i = 0; i < list1.size() - 1; i++){
                        int difference = list1.get(i + 1) - list1.get(i) + 1;
                        if(difference >= count) {
                            row = key1;
                            break;
                        }
                    }
                    ArrayList<Integer> list2 = map.get(key2);
                    Collections.sort(list2);
                    for(int i = 0; i < list2.size() - 1; i++){
                        int difference = list2.get(i + 1) - list2.get(i) + 1;
                        if(difference >= count) {
                            row = key2;
                            break;
                        }
                    }
                }
            }

        }
    }

    private double distance(int x, int yl, int yr) {
        double res = 0;
        for (int i = yl; i <= yr; i++) {
            res += Math.abs(x - xc) + Math.abs(i - yc);
        }
        return res;
    }
}

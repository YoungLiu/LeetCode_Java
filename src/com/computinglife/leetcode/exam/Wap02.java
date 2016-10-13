package com.computinglife.leetcode.exam;

import java.util.*;

/**
 * Created by yliu on 9/27/16.
 */
public class Wap02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();
        int[] points = new int[N];
        for(int i = 0; i < N; i++){
            points[i] = sc.nextInt();
        }
        int[] bestRooms = new int[M];
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 1; i <= N - 1; i++){
            int left = sc.nextInt();
            int right = sc.nextInt();
            if(map.containsKey(left)){
                map.get(left).add(right);
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(right);
                map.put(left, tmp);
            }

            if(map.containsKey(right)){
                map.get(right).add(left);
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(left);
                map.put(right, tmp);
            }
        }
        Map<Integer, ArrayList<Integer>> backup = new HashMap<>(map);
        Set<Integer> alreadyHasWifi = new HashSet<>();
        // for each router find the best room
        for(int i = 0; i < M; i++){
            int max = Integer.MIN_VALUE;
            int bestRoom = -1;
            for(Integer room : map.keySet()){
                ArrayList<Integer> adjacents = map.get(room);
                int sum = 0;
                for(Integer adjacent : adjacents){
                    if(alreadyHasWifi.contains(adjacent)){
                        continue;
                    }
                    sum += points[adjacent - 1];
                }
                sum += points[room - 1];
                if(sum > max){
                    max = sum;
                    bestRoom = room;
                }
            }
            bestRooms[i] = bestRoom;
            alreadyHasWifi.add(bestRoom);
            for(Integer neighbor : backup.get(bestRoom)){
                alreadyHasWifi.add(neighbor);
            }
            map.remove(bestRoom);
        }
        Set<Integer> haveWifi = new HashSet<>();
        for(Integer wifi : bestRooms){
            haveWifi.add(wifi);
            ArrayList<Integer> tmp = backup.get(wifi);
            for(Integer neighbor : tmp){
                haveWifi.add(neighbor);
            }
        }
        int maxPoints = 0;
        for(Integer item : haveWifi){
            maxPoints += points[item - 1];
        }
        System.out.println(maxPoints);
    }
}

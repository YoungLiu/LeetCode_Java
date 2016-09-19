package com.computinglife.leetcode.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by yliu on 9/18/16.
 */
public class Iqiyi01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> everday = new HashMap<>();
        Map<Integer, Integer> task = new HashMap<>();
        while(sc.hasNext()){
            String line = sc.nextLine();
            if(line == null || line.length() == 0 || line.equals("\n")){
                break;
            }
            String[] arrays = line.split(" ");
            if(arrays.length < 2){
                break;
            }
            int[] lineInt = new int[arrays.length];
            for(int i = 0; i < arrays.length; i++){
                lineInt[i] = Integer.parseInt(arrays[i]);
            }
            if(lineInt[0] == 1){
                // day
                for(int i= lineInt[1]; i <= lineInt[2]; i++){
                    if(!everday.containsKey(i)){
                        everday.put(i, lineInt[3]);
                    }else if(everday.get(i) < lineInt[3]){
                        everday.put(i, lineInt[3]);
                    }
                }
            } else if(lineInt[0] == 2){
                //task
                if(!task.containsKey(lineInt[1])){
                    task.put(lineInt[1], lineInt[2]);
                } else if(task.get(lineInt[1]) < lineInt[2]){
                    task.put(lineInt[1], lineInt[2]);
                }
            }
        }
        int count = 0;
        for(Integer day : everday.keySet()){
            count += everday.get(day);
        }
        for (Integer eachTask : task.keySet()) {
            count += task.get(eachTask);
        }
        System.out.println(count);
    }
}

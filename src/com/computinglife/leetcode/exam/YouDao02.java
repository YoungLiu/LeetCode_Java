package com.computinglife.leetcode.exam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by yliu on 8/17/16.
 */
public class YouDao02 {
    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < num; i++){
            int n = Integer.parseInt(sc.nextLine());
            int[] nums = new int[n];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                nums[j] = j + 1;
                sb.append(j+1);
                sb.append(" ");
            }
            String compare = sb.toString().trim();
            allPermutation(nums, 0, nums.length - 1);
            for(ArrayList<Integer> item : list){
                int[] tmp = new int[item.size()];
                for(int j = 0; j < item.size(); j++){
                    tmp[j] = item.get(j);
                }
                String res = convert(tmp);
                if(res.equals(compare)){
                    StringBuilder sb2 = new StringBuilder();
                    for(Integer x : item){
                        sb2.append(x);
                        sb2.append(" ");
                    }
                    System.out.println(sb2.toString().trim());
                }
            }
        }
    }

    public static String convert(int[] nums){
        Queue<Integer> queue = new LinkedList<>();
        for(Integer tmp : nums){
            queue.offer(tmp);
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            queue.offer(tmp);
            sb.append(queue.poll());
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private static void allPermutation(int[] nums, int from, int to) {
        if (to <= 0) {
            return;
        }
        if (from == to) {
            ArrayList<Integer> item = new ArrayList<>();
            for (int i = 0; i <= to; i++) {
                item.add(nums[i]);
            }
            list.add(item);
            return;
        } else {
            for (int j = from; j <= to; j++) {
                swap(nums, j, from);
                allPermutation(nums, from + 1, to);
                swap(nums, j, from);
            }
        }
    }

    private static void swap(int[] nums, int front, int back) {
        int tmp = nums[front];
        nums[front] = nums[back];
        nums[back] = tmp;
        return;
    }
}

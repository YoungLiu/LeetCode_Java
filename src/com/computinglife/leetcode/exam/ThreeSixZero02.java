//package com.computinglife.leetcode.exam;
//
//import java.util.*;
//
///**
// * Created by yliu on 9/10/16.
// */
//public class ThreeSixZero02 {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int ops = sc.nextInt();
//            int maxMem = sc.nextInt();
//            String[] commands = new String[ops];
//            for(int i = 0; i < ops; i++){
//                commands[i] = sc.nextLine();
//            }
//            Map<Integer, Integer> allocated = new HashMap<>();
//            Map<Integer, Integer> free = new HashMap<>();
//            free.put(0, maxMem);
//            int operation = 0;
//            for(String command: commands){
//                String[] items = command.split(" ");
//                SortedSet<Integer> starts = new TreeSet<Integer>(free.keySet());
//                if(items[0].equals("new")){
//                    int newCount = Integer.parseInt(items[1]);
//                    for(Integer start : starts){
//                        if(free.get(start) >= newCount){
//                            operation++;
//                            free.remove(start);
//                            free.put(start + newCount, );
//                        }
//                    }
//                    if(mem >= newCount){
//                        operation++;
//                        mem -= newCount;
//                        allocated.put(operation, newCount);
//                        System.out.println(operation);
//                    } else{
//                        System.out.println("NULL");
//                    }
//                } else if()
//            }
//
//
//        }
//    }
//}

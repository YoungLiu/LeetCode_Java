package com.computinglife.leetcode.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by yliu on 7/30/16.
 */
public class HuaWeiTest03 {

    private static class Timer {
        public Integer id;

        public Long time;

        public Timer(Integer id, Long time) {
            this.id = id;
            this.time = time;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Set<Timer> timers = new HashSet<>();
        while(sc.hasNext()){
            String input = sc.nextLine();
            if(input == null || input.length() == 0){
                continue;
            } else {
                String[] array = input.split(":");
                if(array[0].equals("starttimer")){
                    String[] parameter = array[1].split(",");
                    Timer timer = new Timer(Integer.parseInt(parameter[0]), Long.parseLong(parameter[1]));
                    timers.add(timer);
                } else if (array[0].equals("elapse")){
                    Long elapse = Long.parseLong(array[1]);
                    for(Timer tmp : timers){
                        if(elapse >= tmp.time) {
                            tmp.time = (long)0;
                        }else {
                            tmp.time -= elapse;
                        }
                    }
                } else if (array[0].equals("end")) {
                    for(Timer tmp : timers){
                        if(tmp.time > 0){
                            System.out.printf("timer:%d,%d", tmp.id, tmp.time);
                        }
                    }
                } else if (array[0].equals("stoptimer")){
                    for(Timer tmp : timers){
                        if(tmp.id == Integer.parseInt(array[1])){
                            tmp.time = (long)0;
                        }
                    }
                }else {
                    continue;
                }
            }
        }
    }
}

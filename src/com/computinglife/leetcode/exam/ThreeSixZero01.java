package com.computinglife.leetcode.exam;

import java.util.Scanner;

/**
 * Created by yliu on 9/10/16.
 */
public class ThreeSixZero01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String nm = sc.nextLine();
            String one = sc.nextLine();
            String two = sc.nextLine();
            boolean forward = false;
            boolean backward = false;
            //N --> M
            {
                int indexOne = nm.indexOf(one);
                if (indexOne != -1 && (indexOne + one.length()) < nm.length()) {
                    int indexTwo = nm.indexOf(two, indexOne + one.length());
                    if (indexTwo != -1) {
                        forward = true;
                    }
                }
            }
            // M --> N
            {
                nm = reverse(nm);
                int indexOne = nm.indexOf(one);
                if (indexOne != -1 && (indexOne + one.length()) < nm.length()) {
                    int indexTwo = nm.indexOf(two, indexOne + one.length());
                    if (indexTwo != -1) {
                        backward = true;
                    }
                }
            }
            if(forward && backward){
                System.out.println("both");
            } else if(forward){
                System.out.println("forward");
            } else if(backward){
                System.out.println("backward");
            } else {
                System.out.println("invalid");
            }
        }
    }

    public static String reverse(String s) {
        int length = s.length();
        if (length <= 1)
            return s;
        String left = s.substring(0, length / 2);
        String right = s.substring(length / 2, length);
        return reverse(right) + reverse(left);
    }
}

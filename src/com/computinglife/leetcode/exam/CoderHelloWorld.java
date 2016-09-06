package com.computinglife.leetcode.exam;

/**
 * Created by yliu on 9/5/16.
 */
public class CoderHelloWorld {

    public boolean isHelloWorld(String text) {
        if (text == null) {
            return false;
        }
        char[] array = text.toCharArray();
        char last = '*';
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for (char item : array) {
            if (item != 'l') {
                if (item != last) {
                    sb.append(item);
                    last = item;
                } else if (item == last) {
                    continue;
                }
            } else {
                if(flag){
                    //first time to see l
                    sb.append(item);
                    flag = false;
                    last = '*';
                }else {
                    if (item != last) {
                        sb.append(item);
                        last = item;
                    } else if (item == last) {
                        continue;
                    }
                }
            }
        }
        System.out.println(sb.toString());
        return sb.toString().equals("helloworld");
    }

    public static void main(String[] args) {
        CoderHelloWorld test = new CoderHelloWorld();
        System.out.println(test.isHelloWorld("hhhhhhhheeeeeeeellllllllowwwwwwwworlllllllld"));
    }
}

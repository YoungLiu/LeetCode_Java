package com.computinglife.leetcode.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by YanceyLiu on 4/6/2016.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> argsList = new ArrayList<>();
        int caseNum = 0;
        if (in.hasNext()) {
            caseNum = Integer.parseInt(in.nextLine());
        }
        int tmp = caseNum * 2;
        while (tmp > 0) {
            argsList.add(in.nextLine());
            tmp--;
        }
        for (int i = 0; i < caseNum*2; i++) {
            String[] arg1 = argsList.get(i).split(" ");
            String[] arg2 = argsList.get(++i).split(" ");
            int[] arg1Arr = new int[arg1.length];
            int[] arg2Arr = new int[arg2.length];
            for(int j = 0;j<arg1.length;j++){
                arg1Arr[j] = Integer.parseInt(arg1[j]);
            }
            for(int j =0;j<arg2.length;j++){
                arg2Arr[j] = Integer.parseInt(arg2[j]);
            }

            System.out.println(getFontSize(arg1Arr[1], arg2Arr, arg1Arr[2], arg1Arr[3]));
        }

    }

    public static int getFontSize(int page, int[] paragraphs, int width, int height) {
        int sum = 0;
        int size = 1;
        for (int tmp : paragraphs) {
            sum += tmp;
        }
        double threshold = sum / page;
        while (true) {
            if (Math.floor(width / size) * Math.floor(height / size) < threshold) {
                return size - 1;
            }
            size++;
        }

    }
}

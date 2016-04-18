package com.computinglife.leetcode.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by youngliu on 2/21/16.
 */
public class TestRunTime {

    public static void main(String[] args) {
        try {
            Process p = Runtime.getRuntime().exec("ping www.baidu.com");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

package com.computinglife.leetcode.test;

import java.io.*;

/**
 * Created by yliu on 7/10/16.
 */
public class TestFile {

    public static void main(String[] args) {
        try {
            String pathname = "input/testinput";
            File filename = new File(pathname);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            while (line != null) {
                line = br.readLine(); // 一次读入一行数据
                System.out.println(line);
            }

            /*
            * writing code here
            * */

            File writename = new File("output/output.txt");
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write("我会写入文件啦\r\n");
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

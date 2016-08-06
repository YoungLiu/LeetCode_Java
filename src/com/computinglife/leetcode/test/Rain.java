package com.computinglife.leetcode.test;

import java.io.*;

/**
 * Created by yliu on 7/10/16.
 */
public class Rain {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        try {
            String pathname = "input/testinput";
            File filename = new File(pathname);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            Integer numCase = Integer.parseInt(br.readLine());
            while (numCase-- > 0) {
                String[] rowAndColume = br.readLine().split(" ");
                int row = Integer.parseInt(rowAndColume[0]);
                int colume = Integer.parseInt(rowAndColume[1]);
                int[][] matrix = new int[row + 2][colume + 2];
                int sum = 0;
                // init matrix
                for (int i = 0; i < row + 2; i++) {
                    if (i == 0 || i == row + 1) {
                        for (int j = 0; j < colume + 2; j++) {
                            matrix[i][j] = 0;
                        }
                        continue;
                    }
                    String[] rowLine = br.readLine().split(" ");
                    for (int j = 0; j < colume + 2; j++) {
                        if (j == 0 || j == colume + 1) {
                            matrix[i][j] = 0;
                        } else {
                            matrix[i][j] = Integer.parseInt(rowLine[j - 1]);
                        }
                    }
                }
                int[][] flag = new int[row + 2][colume + 2];
                for (int i = 1; i <= row; i++) {
                    for (int j = 1; j <= colume; j++) {
                        if (flag[i][j] == 0) {
                            if (matrix[i - 1][j] < matrix[i][j] || matrix[i][j - 1] < matrix[i][j] || matrix[i][j + 1] < matrix[i][j] || matrix[i + 1][j] < matrix[i][j]) {
                                continue;
                            } else {


                            }
                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static int getMin(int a, int b, int c, int d){
        int tmpA = a > b? b: a;
        int tmpC = c > tmpA ? tmpA:c;
        int ret = d > tmpC? tmpC : d;
        return ret;
    }

    private static void writeFile(String output) {
        try {
            File writename = new File("output/output.txt");
            writename.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write(output);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

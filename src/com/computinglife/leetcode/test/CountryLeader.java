package com.computinglife.leetcode.test;

import java.io.*;
import java.util.*;

/**
 * Created by yliu on 7/10/16.
 */
public class CountryLeader {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        try {
            String pathname = "input/A-large.in";
            File filename = new File(pathname);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            // the number of case
            Integer caseNum = Integer.parseInt(br.readLine());
            int caseNumber = 1;
            while (caseNum-- > 0) {
                Integer numPeople = Integer.parseInt(br.readLine());
                int count = 0;
                String retName = "";
                for (int i = 0; i < numPeople; i++) {
                    String name = br.readLine();
                    Set<Character> set = new HashSet<>();
                    boolean flag = false;
                    for (char c : name.toCharArray()) {
                        if (c >= 'A' && c <= 'Z') {
                            set.add(c);
                        }else if(c != ' '){
                            flag = true;
                            break;
                        }
                    }
                    if(set.size() == 0 || flag){
                        continue;
                    }
                    if (count < set.size()) {
                        count = set.size();
                        retName = name;
                    } else if (count == set.size()) {
                        if(retName.compareTo(name) > 0){
                            retName = name;
                        }
                    }
                }
                String retToWrite = "";
                if (caseNum == 0) {
                    retToWrite = "Case #" + (caseNumber++) + ": " + retName;
                } else {
                    retToWrite = "Case #" + (caseNumber++) + ": " + retName + "\n";
                }
                sb.append(retToWrite);
            }
            writeFile(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

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

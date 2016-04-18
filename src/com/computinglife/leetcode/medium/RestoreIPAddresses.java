/*Given a string containing only digits, restore it by returning all possible valid IP address combinations.

        For example:
        Given "25525511135",

        return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youngliu on 12/27/15.
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        helper(res, list, s, 0);
        return res;
    }

    public void helper(List<String> res, List<String> list, String s, int start) {
        if (list.size() == 4) {
            if (start != s.length()) {
                return;
            }
            StringBuffer sb = new StringBuffer();
            for (String tmp : list) {
                sb.append(tmp);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        for (int i = start; i < s.length() && i <= start + 2; i++) {
            String tmp = s.substring(start, i + 1);
            if (isValid(tmp)) {
                list.add(tmp);
                helper(res, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }
        int digit = Integer.parseInt(s);
        return digit >= 0 && digit <= 255;
    }

}

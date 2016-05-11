/*Write a function that takes a string as input and reverse only the vowels of a string.

        Example 1:
        Given s = "hello", return "holle".

        Example 2:
        Given s = "leetcode", return "leotcede".*/

package com.computinglife.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by YanceyLiu on 4/28/2016.
 */
public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        char[] sArray = s.toCharArray();
        Set<Character> vowel = new HashSet<Character>() {{
            add('a');
            add('A');
            add('e');
            add('E');
            add('i');
            add('I');
            add('o');
            add('O');
            add('u');
            add('U');
        }};
        int low = 0;
        int high = sArray.length - 1;
        while (low < high) {
            if(vowel.contains(sArray[low])){
                for(int j = high;j>low;j--){
                    if(vowel.contains(sArray[j])){
                        char tmp = sArray[low];
                        sArray[low] = sArray[j];
                        sArray[j] = tmp;
                        high = j-1;
                        break;
                    }
                }
            }
            low++;
        }
        //return sArray.toString();
        return String.valueOf(sArray);
    }

    public static void main(String[] args){
        ReverseVowelsofaString test = new ReverseVowelsofaString();
        System.out.println(test.reverseVowels("hello"));
    }
}

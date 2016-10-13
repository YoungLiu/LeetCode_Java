package com.computinglife.leetcode.exam;

/**
 * Created by yliu on 9/24/16.
 */
public class Jiaying01 {
    public static void printLongestSumSubsequence(int[] seq) {
        int[] S = new int[seq.length];

        //S[j] contains the longest sum of subsequence a1,a2,a3,....,aj
        //So a sub sequence with length 1 will only contain first element.
        //Hence we initialize it like this
        S[0] = seq[0];
        int min_index = 0;
        int max_index = 0;

        //Now like any dynamic problem we proceed by solving sub problems and
        //using results of subproblems to calculate bigger problems
        for(int i = 1; i < seq.length; i++) {

            //Finding longest sum sub-sequence ending at j
            int max = seq[i];
            int idx = i;
            int sum = seq[i];
            for(int j = i-1; j >=0 ; j--) {
                sum += seq[j];
                if(max < sum) {
                    idx = j;
                    max = sum;
                }
            }
            //Now we know the longest sum subsequence ending at j, lets see if its
            //sum is bigger than S(i-1) or less
            //This element is part of longest sum subsequence
            if(max > S[i-1]) {
                S[i] = max;
                max_index = i;
                min_index = idx;
            } else {
                //This element is not part of longest sum subsequence
                S[i] = S[i-1];
            }
        }

        System.out.println("Biggest Sum : "+S[seq.length - 1]);
        //Print the sequence
        for(int idx = min_index; idx <= max_index; idx++) {
            System.out.println("Index " + idx +  "Element " + seq[idx]);
        }
    }

    public static void main(String[] args) {
        int[] seq = {5,15,-30,10,-5,40,10};
        printLongestSumSubsequence(seq);
    }
}

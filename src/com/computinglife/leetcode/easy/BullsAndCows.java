/*You are playing the following Bulls and Cows game with your friend:
        You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess,
        you provide a hint that indicates how many digits in said guess match your secret number exactly
        in both digit and position (called "bulls") and how many digits match the secret number
        but locate in the wrong position (called "cows"). Your friend will use successive guesses
        and hints to eventually derive the secret number.
        For example:

        Secret number:  "1807"
        Friend's guess: "7810"
        Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
        Write a function to return a hint according to the secret number and friend's guess,
        use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".

        Please note that both secret number and friend's guess may contain duplicate digits, for example:

        Secret number:  "1123"
        Friend's guess: "0111"
        In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow,
        and your function should return "1A1B".
        You may assume that the secret number and your friend's guess only contain digits,
        and their lengths are always equal.*/

package com.computinglife.leetcode.easy;

import java.util.*;

/**
 * Created by YanceyLiu on 5/16/2016.
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null || secret.length() == 0 || guess.length() == 0) {
            return null;
        }
        char[] secretS = secret.toCharArray();
        char[] guessS = guess.toCharArray();
        Map<Character, List<Integer>> positionS = new HashMap<>();
        Map<Character, List<Integer>> positionG = new HashMap<>();
        //init
        for (int i = 0; i < secretS.length; i++) {
            if (positionS.containsKey(secretS[i])) {
                positionS.get(secretS[i]).add(i);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                positionS.put(secretS[i], tmp);
            }
            if (positionG.containsKey(guessS[i])) {
                positionG.get(guessS[i]).add(i);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                positionG.put(guessS[i], tmp);
            }
        }
        int bulls = 0, cows = 0;
        for (Character g : positionG.keySet()) {
            if (positionS.containsKey(g)) {
                List<Integer> interSet = new ArrayList<>(positionS.get(g));
                interSet.retainAll(positionG.get(g));
                bulls += interSet.size();
                positionS.get(g).removeAll(interSet);
                positionG.get(g).removeAll(interSet);
                cows += Math.min(positionG.get(g).size(), positionS.get(g).size());
            }
        }

        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        BullsAndCows test = new BullsAndCows();
        System.out.println(test.getHint("0113", "1101"));
    }
}

/*There are n bulbs that are initially off. You first turn on all the bulbs.
Then, you turn off every second bulb. On the third round, you toggle every third bulb
(turning on if it's off or turning off if it's on). For the nth round, you only toggle the last bulb.
Find how many bulbs are on after n rounds.

        Example:

        Given n = 3.

        At first, the three bulbs are [off, off, off].
        After first round, the three bulbs are [on, on, on].
        After second round, the three bulbs are [on, off, on].
        After third round, the three bulbs are [on, off, off].

        So you should return 1, because there is only one bulb is on.*/

//http://traceformula.blogspot.com/2015/12/bulb-switcher-leetcode.html

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 12/21/15.
 */
public class BulbSwitcher {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}

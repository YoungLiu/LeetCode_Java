package com.computinglife.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yliu on 9/8/16.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0 || intervals.size() == 1) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        List<Interval> res = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval interval : intervals){
            if(interval.start <= end){
                end = Math.max(end, interval.end);
            }else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
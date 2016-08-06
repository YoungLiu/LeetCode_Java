package com.computinglife.leetcode.exam;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by yliu on 8/5/16.
 */
public class Huawei03 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = Integer.parseInt(str);
        Test(count);
    }

    public static void Test(int m) {
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
                Scanner sc = new Scanner(System.in);
                String str1 = sc.nextLine();
                String[] array = str1.split(" ");
                int nNum = Integer.parseInt(array[0]);
                int mNum = Integer.parseInt(array[1]);
                Vector b = new Vector();
                Vector w = new Vector();
                for(int j = 0; j < nNum; j++){
                    String tmp = sc.nextLine();
                    String[] arrayTmp = tmp.split(" ");
                    b.add(j, new Point(Integer.parseInt(arrayTmp[0]), Integer.parseInt(arrayTmp[1])));
                }
                for (int j = 0; j < mNum; j++) {
                    String tmp = sc.nextLine();
                    String[] arrayTmp = tmp.split(" ");
                    w.add(j, new Point(Integer.parseInt(arrayTmp[0]), Integer.parseInt(arrayTmp[1])));
                }
                result[i] = WB(w, b);
        }
        for (int r = 0; r < m; r++) {
            System.out.println(result[r]);
        }
    }

    public static int WB(Vector w, Vector b)/*核心算法*/ {
        Collections.sort(w, new Point.MyPointComparatorByXAC());
        Collections.sort(b, new Point.MyPointComparatorByXAC());
        int pp = 0;
        for (int i = w.size() - 1; i >= 0; i--) {
            Point gpp = new Point(-32768, -32768);
            for (int j = b.size() - 1; j >= 0; j--) {
                Point mb = (Point) b.get(j);
                Point mw = (Point) w.get(i);
                if (mb.getX() < mw.getX()) {
                    break;
                }
                if (mb.getY() < mw.getY()) {
                    continue;
                }
                if (gpp.getY() == -32768) {
                    gpp = mb;
                } else {
                    if (gpp.getY() < mb.getY()) {
                        gpp = mb;
                    }
                }
            }
            if (gpp.getY() != -32768) {
                pp++;
            }
        }
        return pp;
    }

}

class Point //implements Comparable
{
    private float x;
    private float y;

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public Point() {
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static class MyPointComparatorByXAC implements Comparator {
        public int compare(Object o1, Object o2) {
            Point p1 = (Point) o1;
            Point p2 = (Point) o2;
            int result = (p1.getX() > p2.getX()) ? 1 : (p1.getX() == p2.getX() ? 0 : -1);
            return result;
        }
    }

    public static class MyPointComparatorByYDESC implements Comparator {
        public int compare(Object o1, Object o2) {
            Point p1 = (Point) o1;
            Point p2 = (Point) o2;
            int result = (p1.getY() < p2.getY()) ? 1 : (p1.getY() == p2.getY() ? 0 : -1);
            return result;
        }
    }
}
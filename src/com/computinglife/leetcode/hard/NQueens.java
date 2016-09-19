package com.computinglife.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yliu on 9/8/16.
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n <= 0){
            return res;
        }
        char[] line = new char[n];
        for(int i = 0; i < n; i++){
            line[i] = '.';
        }
        List<char[]> nQueue = new ArrayList<>();
        for(int i = 0; i < n; i++){
            nQueue.add(Arrays.copyOf(line, line.length));
        }
        nQueues(res, nQueue, 0, n);
        return res;
    }

    private void nQueues(List<List<String>> res, List<char[]> item, int row, int n){
        if(row == n){
            List<String> tmp = new ArrayList<>();
            for(char[] chars : item){
                tmp.add(new String(chars));
            }
            res.add(tmp);
            return;
        }
        for(int col = 0; col < n; col++){
            if(isValid(item, row, col, n)){
                item.get(row)[col] = 'Q';
                nQueues(res, item, row + 1, n);
                item.get(row)[col] = '.';
            }
        }

    }

    private boolean isValid(List<char[]> item, int row, int col, int n) {
        //check this col
        for(int i = 0; i != row; i++){
            if(item.get(i)[col] == 'Q'){
                return false;
            }
        }
        //check the 45 diagonal
        for(int i = row - 1, j = col - 1; i >=0 && j >= 0; i--, j--){
            if(item.get(i)[j] == 'Q'){
                return false;
            }
        }
        //check the 135 diagonal
        for(int i = row -1, j = col + 1; i >= 0 && j < n; i--,j++){
            if(item.get(i)[j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        NQueens test = new NQueens();
        List<List<String>> res = test.solveNQueens(4);
        for(List<String> item : res){
            System.out.println("+++++++++++++++++++++");
            for(String tmp : item){
                System.out.println(tmp);
            }
        }
    }
}

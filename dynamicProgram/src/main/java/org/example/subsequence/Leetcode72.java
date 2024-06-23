package org.example.subsequence;

import java.util.Arrays;

public class Leetcode72 {
    int[][] mem;
    public int minDistance(String word1, String word2) {
        mem = new int[word1.length()][word2.length()];
        for(int i = 0; i < mem.length; i++)
            Arrays.fill(mem[i], -1);
        return dp(word1.length() - 1, word2.length() - 1, word1, word2);
    }
    private int dp(int i, int j, String word1, String word2){
        if(i < 0 ) return j + 1;
        if(j < 0 ) return i + 1;

        if(mem[i][j] != -1) return mem[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            mem[i][j] = dp(i -1, j - 1, word1, word2);
        }else{
            mem[i][j] = myMin(dp(i -1, j, word1, word2),
                    dp(i - 1, j - 1, word1, word2),
                    dp(i, j - 1, word1, word2)) + 1;
        }
        return mem[i][j];
    }

    private int myMin(int a, int b, int c){
        int min = a < b ? a : b;
        return min < c ? min : c;
    }
}


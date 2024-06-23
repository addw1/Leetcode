package org.example.subsequence;

import java.util.Arrays;

public class Leetcode300 {
    int[] mem;
    public int lengthOfLIS(int[] nums) {
        mem = new int[nums.length];
        Arrays.fill(mem, -1);
        mem[0] = 1;
        for(int i = 0; i < nums.length; i++){
            dp(nums, i);
        }
        int max = Integer.MIN_VALUE;
        for(Integer i :mem){
            if(max < i) max = i;
        }
        return max;
    }
    int dp(int[] nums, int i){
        // mem store
        if(mem[i] != -1)
            return mem[i];

        // dp
        int max = Integer.MIN_VALUE;
        for(int j = 0; j < i; j++){
            if(nums[j] < nums[i]){
                int temp = dp(nums, j);
                if(temp > max) max = temp;
            }
        }

        if(max == Integer.MIN_VALUE) max = 0;
        mem[i] = max + 1;
        return mem[i];
    }
}
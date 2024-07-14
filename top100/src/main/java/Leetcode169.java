import java.util.HashMap;

public class Leetcode169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int freq = myMap.getOrDefault(nums[i], 0) + 1;
            myMap.put(nums[i], freq);
            if(freq > nums.length / 2) return nums[i];
        }
        return -11;
    }
}

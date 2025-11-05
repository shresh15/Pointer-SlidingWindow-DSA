/*
 * Given an integer array nums and an integer k, return the number of good
 * subarrays of nums.
 * 
 * A good array is an array where the number of different integers in that array
 * is exactly k.
 * 
 * For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
 * A subarray is a contiguous part of an array.
 */

import java.util.HashMap;

class Subarray {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmostK(nums, k) - atmostK(nums, k - 1);
    }

    public int atmostK(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int left = 0, count = 0, right = 0;
        for (right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            if (freq.get(nums[right]) == 1)
                k--;

            while (k < 0) {// SHRINK the window
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0)
                    k++;
                left++;
            }

            count = count + (right - left + 1);

        }
        return count;

    }
}
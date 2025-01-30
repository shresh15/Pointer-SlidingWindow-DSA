/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0,r=0,maxlen=0,zeros=0,len=0;
        while(r<nums.length){
            if(nums[r]==0) zeros++;
            if(zeros>k)
                {
                    if(nums[l]==0) zeros--;
                    l++;
                }
            if(zeros<=k){
                len=r-l+1;
                maxlen=Math.max(len,maxlen);
            }

            r++;
            }

            return maxlen;
        }
    }
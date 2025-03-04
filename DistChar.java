//Given a string s, find the length of the longest substring without repeating characters.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n=s.length();
        
        int left=0,right=0;
        int len=0;
        HashMap<Character,Integer>mpp=new HashMap<>();
        while(right<n){
            if(mpp.containsKey(s.charAt(right))){
                
                left=Math.max(mpp.get(s.charAt(right))+1, left);
            }
            mpp.put(s.charAt(right),right);
            len=Math.max(len, right-left+1);
            right++;
            
        }
       return len; 
        
    }
}
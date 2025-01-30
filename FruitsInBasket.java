/*
Given an array arr[] containing positive elements, the task is to find the length of the longest subarray of an input array containing at most two distinct integers.
*/
class Solution {
    public static int totalElements(Integer[] arr) {
        // code here
        HashMap<Integer,Integer>mpp=new HashMap<>();
        int l=0,r=0,maxlen=0;
        while(r<arr.length){

            mpp.put(arr[r],mpp.getOrDefault(arr[r],0)+1);

            if(mpp.size()>2){

                if(mpp.containsKey(arr[l])){
                    
                    mpp.put(arr[l],mpp.get(arr[l])-1);
                }
                
                if(mpp.get(arr[l])==0) mpp.remove(arr[l]);
                
                l++;
            }
            
            if(mpp.size()<=2){
                maxlen=Math.max(maxlen,r-l+1);
                
            }
            r++;
        }
        
        return maxlen;
    }
}
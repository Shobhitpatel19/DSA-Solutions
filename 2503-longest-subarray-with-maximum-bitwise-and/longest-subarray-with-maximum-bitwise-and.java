class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
       int len = 0;
       
       for(int i = 0; i < nums.length; i++){
           if(nums[i] > max){
               max = nums[i];
               len = 1;
               while(i < nums.length - 1 && nums[i] == nums[i+1] ){
                   i++; len++;
               }
           }else if(nums[i] == max){
               int tempLen = 1;
               while(i < nums.length - 1 && nums[i] == nums[i+1] ){
                   i++; tempLen++;
               }
               len = Math.max(len, tempLen);
           }
       }
       
       return len;
    }
}
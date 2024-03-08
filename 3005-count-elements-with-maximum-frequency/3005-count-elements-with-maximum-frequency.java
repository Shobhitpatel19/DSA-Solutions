class Solution {
    public int maxFrequencyElements(int[] nums) {
      int maxNum = Integer.MIN_VALUE;
      for(int num:nums){
         if(num>maxNum) maxNum = num;
      }
       
       int arr[] = new int[maxNum+1];
       for(int num2:nums){
           arr[num2]++;
       }

        int maxFrequency = 0;
        for (int freq : arr) {
            if (freq > maxFrequency) {
                maxFrequency = freq;
            }
        }

         int countMaxFrequency = 0;
        for (int freq : arr) {
            if (freq == maxFrequency) {
                countMaxFrequency++;
            }
        }
    return maxFrequency*countMaxFrequency;
}
}
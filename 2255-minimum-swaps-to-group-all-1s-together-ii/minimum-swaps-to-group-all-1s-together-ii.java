class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int ones = 0, onesInWindow = 0, cntOne = 0;
        for(int num: nums){
            if(num == 1) ones++;
        }
        for(int i = 0; i < n + ones; i++){
            if(i >= ones && nums[i - ones] == 1) cntOne--;
            if(nums[i % n] == 1) cntOne++;
            onesInWindow = Math.max(cntOne, onesInWindow);
        }
        return ones - onesInWindow;
    }
}
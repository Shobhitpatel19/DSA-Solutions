class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If the middle element is less than the next element, 
            // there must be a peak on the right
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                // Otherwise, there must be a peak on the left side
                right = mid;
            }
        }
        return left; // Left pointer will eventually converge to a peak element
    }
}

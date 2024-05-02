class Solution {
    public int findMaxK(int[] nums) {
        int result = -1;
        int[] arr = new int[2001];

        for (int num : nums) {
            if (arr[-num + 1000] == 1) {
                result = Math.max(result, Math.abs(num));
            }
            // Mark the current number as seen
            arr[num + 1000] = 1;
        }

        return result;
    }
}
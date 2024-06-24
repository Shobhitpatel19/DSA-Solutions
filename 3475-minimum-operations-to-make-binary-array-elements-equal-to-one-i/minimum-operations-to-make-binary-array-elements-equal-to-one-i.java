class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int k = 3;
        int flips = 0;
        Deque<Integer> flipQue = new LinkedList<>();
        int flipCountFromPastForCurri = 0;

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                flipCountFromPastForCurri -= flipQue.pollFirst();
            }

            if (flipCountFromPastForCurri % 2 == nums[i]) {
                if (i + k > n) {
                    return -1;
                }
                flipCountFromPastForCurri++;
                flipQue.addLast(1);
                flips++;
            } else {
                flipQue.addLast(0);
            }
        }

        return flips;
    }
}
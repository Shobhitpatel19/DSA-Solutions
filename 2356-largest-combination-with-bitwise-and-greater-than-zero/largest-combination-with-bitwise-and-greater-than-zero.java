class Solution {
    public int largestCombination(int[] candidates) {
        int maxCombinationSize = 0;

        // We need to consider up to 24 bits since 10^7 < 2^24
        for (int bit = 0; bit < 24; bit++) {
            int count = 0;
            for (int candidate : candidates) {
                // Check if the bit at position `bit` is set (1)
                if ((candidate & (1 << bit)) != 0) {
                    count++;
                }
            }
            // Update the maximum size of a valid combination
            maxCombinationSize = Math.max(maxCombinationSize, count);
        }

        return maxCombinationSize;
    }
}
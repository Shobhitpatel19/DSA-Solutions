class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int zeroes = 0;

        // Count total number of '0's in the string
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeroes++;
            }
        }

        int newZero = 0, one = 0, ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                one++;
            } else {
                newZero++;
            }

            if (i != 0) { // Avoid splitting at the start
                ans = Math.max(ans, one + (zeroes - newZero));
            }
        }
        return ans;
    }
}
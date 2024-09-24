class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        int max = 0;  // Initialize max to 0
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;

        while(j < n) {
            char charj = s.charAt(j);

            if(!set.contains(charj)) {
                set.add(charj);
                j++;
                max = Math.max(max, j - i); // Update max length for the current window
            } else {
                set.remove(s.charAt(i));  // Remove the leftmost character
                i++;
            }
        }
        return max;
    }
}
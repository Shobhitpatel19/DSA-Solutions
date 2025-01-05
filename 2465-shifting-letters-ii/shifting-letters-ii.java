class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        // Using long to handle large number of shifts
        long[] diff = new long[n + 1];
        
        // Process all shifts using prefix sum technique
        for(int[] shift : shifts) {
            int value = shift[2] == 1 ? 1 : -1;
            diff[shift[0]] += value;
            diff[shift[1] + 1] -= value;
        }
        
        // Calculate cumulative shift at each position
        StringBuilder sb = new StringBuilder(s);
        long currentShift = 0;
        
        for(int i = 0; i < n; i++) {
            currentShift = (currentShift + diff[i]) % 26;
            // Get original character position and add shift
            long newPos = (s.charAt(i) - 'a' + currentShift + 26000) % 26;
            sb.setCharAt(i, (char)('a' + newPos));
        }
        
        return sb.toString();
    }
}
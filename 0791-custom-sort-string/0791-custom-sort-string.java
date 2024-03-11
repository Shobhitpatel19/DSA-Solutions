class Solution {
    public String customSortString(String order, String s) {
        int[] count = new int[256]; // Assuming ASCII characters
        
        // Count occurrences of characters in s
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        
        StringBuilder result = new StringBuilder();
        
        // Append characters according to order
        for (char c : order.toCharArray()) {
            while (count[c] > 0) {
                result.append(c);
                count[c]--;
            }
        }
        
        // Append remaining characters not present in order
        for (char c = 0; c < 256; c++) {
            while (count[c] > 0) {
                result.append(c);
                count[c]--;
            }
        }
        
        return result.toString();
    }
}

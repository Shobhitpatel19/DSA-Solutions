//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p) {
        // If p is longer than s, it's impossible to find a window.
        if (s.length() < p.length()) {
            return "-1";
        }

        // Map to store the frequency of characters in p.
        HashMap<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        // Variables to track the window.
        int start = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        int matched = 0;  // Number of characters matched so far.

        // Map to store the frequency of characters in the current window.
        HashMap<Character, Integer> windowMap = new HashMap<>();

        // Sliding window using two pointers.
        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);

            // If the current character is part of p, include it in the window.
            if (pMap.containsKey(endChar)) {
                windowMap.put(endChar, windowMap.getOrDefault(endChar, 0) + 1);

                // If the count of the current character in the window matches that in p, increase matched.
                if (windowMap.get(endChar).intValue() == pMap.get(endChar).intValue()) {
                    matched++;
                }
            }

            // Try to shrink the window from the left if all characters are matched.
            while (matched == pMap.size()) {
                // Update the minimum window length if the current window is smaller.
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }

                char startChar = s.charAt(start);

                // Shrink the window by moving the start pointer to the right.
                if (pMap.containsKey(startChar)) {
                    // If the frequency of the start character in the window is reduced below that in p, decrease matched.
                    if (windowMap.get(startChar).intValue() == pMap.get(startChar).intValue()) {
                        matched--;
                    }
                    windowMap.put(startChar, windowMap.get(startChar) - 1);
                }
                start++;
            }
        }

        // If no valid window is found, return "-1".
        return minLen == Integer.MAX_VALUE ? "-1" : s.substring(minStart, minStart + minLen);
    }
}
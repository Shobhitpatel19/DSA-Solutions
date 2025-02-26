//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            ArrayList<Integer> result = solution.maxOfMins(arr);
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] nextSmaller = new int[n];
        int[] prevSmaller = new int[n];
        int[] res = new int[n + 1];  // Store max of minimums for each window size
        
        // Step 1: Find Next Smaller Element (NSE)
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                nextSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            nextSmaller[stack.pop()] = n; // No smaller element, extend to end
        }
        
        // Step 2: Find Previous Smaller Element (PSE)
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                prevSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            prevSmaller[stack.pop()] = -1; // No smaller element, extend to start
        }
        
        // Step 3: Compute Window Size for Each Element
        for (int i = 0; i < n; i++) {
            int windowSize = nextSmaller[i] - prevSmaller[i] - 1;
            res[windowSize] = Math.max(res[windowSize], arr[i]);
        }
        
        // Step 4: Fill Remaining Entries in Result Array
        for (int i = n - 1; i >= 1; i--) {
            res[i] = Math.max(res[i], res[i + 1]);
        }

        // Step 5: Collect Results in ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(res[i]);
        }
        return result;
    }
}

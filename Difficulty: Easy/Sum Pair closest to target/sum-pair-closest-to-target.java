//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
    if (arr.length < 2) return new ArrayList<>();
    
    Arrays.sort(arr);
    int left = 0, right = arr.length - 1;
    int minDiff = Integer.MAX_VALUE;
    int resLeft = -1, resRight = -1;
    
    while (left < right) {
        int sum = arr[left] + arr[right];
        int diff = Math.abs(sum - target);
        
        // Update result if current diff is smaller or 
        // if equal diff but larger absolute difference between elements
        if (diff < minDiff || (diff == minDiff && 
            Math.abs(arr[right] - arr[left]) > Math.abs(resRight - resLeft))) {
            minDiff = diff;
            resLeft = arr[left];
            resRight = arr[right];
        }
        
        if (sum < target) left++;
        else if (sum > target) right--;
        else break;
    }
    
    if (resLeft == -1) return new ArrayList<>();
    return Arrays.asList(resLeft, resRight);
}
}
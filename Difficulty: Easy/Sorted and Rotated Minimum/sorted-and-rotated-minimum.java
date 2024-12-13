//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        Solution ob = new Solution(); // Instantiate the Solution object once

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int[] arr = new int[elements.length]; // Changed to int[]

            for (int i = 0; i < elements.length; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            System.out.println(ob.findMin(arr));
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findMin(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If right element is larger, minimum is in left half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } 
            // If right element is smaller, minimum is in left half including mid
            else if (arr[mid] < arr[right]) {
                right = mid;
            } 
            // When elements are equal, we can't determine which half
            // So we reduce the search space by moving right pointer
            else {
                right--;
            }
        }
        
        return arr[left];
    }
}

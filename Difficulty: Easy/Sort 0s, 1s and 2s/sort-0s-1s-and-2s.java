//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            int a[] = new int[inputArray.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(inputArray[i]);

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}


// } Driver Code Ends


class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        int low = 0;       // pointer for 0s
        int mid = 0;       // current element being examined
        int high = arr.length - 1;  // pointer for 2s
        
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    // Swap 0 to the low section
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                    
                case 1:
                    // 1 is in the right place, just move mid
                    mid++;
                    break;
                    
                case 2:
                    // Swap 2 to the high section
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }
    
    // Helper method to swap elements in the array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}



//{ Driver Code Starts.
// } Driver Code Ends
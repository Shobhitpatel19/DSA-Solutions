//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
        int n = arr1.length;
        int low = 0, high = n;
        
        while (low <= high) {
            int i = (low + high) / 2;
            int j = n - i;
            
            int arr1LeftMax = (i == 0) ? Integer.MIN_VALUE : arr1[i - 1];
            int arr1RightMin = (i == n) ? Integer.MAX_VALUE : arr1[i];
            
            int arr2LeftMax = (j == 0) ? Integer.MIN_VALUE : arr2[j - 1];
            int arr2RightMin = (j == n) ? Integer.MAX_VALUE : arr2[j];
            
            if (arr1LeftMax <= arr2RightMin && arr2LeftMax <= arr1RightMin) {
                int middleSum = Math.max(arr1LeftMax, arr2LeftMax) + Math.min(arr1RightMin, arr2RightMin);
                return middleSum;
            } else if (arr1LeftMax > arr2RightMin) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }
        
        throw new IllegalArgumentException("Input arrays are not sorted or of equal length");

    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends
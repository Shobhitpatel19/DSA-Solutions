//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String st[] = read.readLine().trim().split("\\s+");
            int n = st.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) arr[(int)i] = Integer.parseInt(st[(int)i]);

            System.out.println(new Solution().maxStep(arr));
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find maximum number of consecutive steps
    // to gain an increase in altitude with each step.
    public int maxStep(int arr[]) {
        // Your code here
        int i = 0, j = 0, n = arr.length, count = 0;
        
        while(i<n-1 && j<n-1){
            if(arr[i] >= arr[i+1]){
                i++;
                continue;
            }
            
            j = i+1;
            while(j<n-1){
                if(arr[j] < arr[j+1]){
                    j++;
                }else{
                    break;
                }
            }
            
            count = Math.max(count, j-i);
            i = j;
        }
        return count;
    }
}
//{ Driver Code Starts
import java.io.*;
import java.util.*;

// Driver class

// } Driver Code Ends
// User function Template for Java

class Solution {
    public long maxSum(Long[] arr) {
        // code here
        int n = arr.length;
        
        // Sort the array to arrange in zig-zag pattern
        Arrays.sort(arr);
        
        // Create a new array to store the ordered elements
        Long[] temp = new Long[n];
        
        int left = 0, right = n - 1;
        boolean flag = true;
        
        // Arrange elements in min, max, second min, second max order
        for (int i = 0; i < n; i++) {
            if (flag) {
                temp[i] = arr[left++];
            } else {
                temp[i] = arr[right--];
            }
            flag = !flag;
        }
        
        // Calculate the sum of absolute differences in circular manner
        long maxSum = 0;
        for (int i = 0; i < n - 1; i++) {
            maxSum += Math.abs(temp[i] - temp[i + 1]);
        }
        
        // Add the absolute difference between the last and first element to close the circular array
        maxSum += Math.abs(temp[n - 1] - temp[0]);
        
        return maxSum;
    }
}


//{ Driver Code Starts.
class Main {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the Long integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into Long integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            // Convert ArrayList to array
            Long[] arr = new Long[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call maxSum method and print result
            long ans = ob.maxSum(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends
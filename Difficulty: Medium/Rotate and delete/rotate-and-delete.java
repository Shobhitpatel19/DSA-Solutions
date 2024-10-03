//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public static int rotateDelete(ArrayList<Integer> arr) {
        // code here
        // code here
        int n = arr.size(), temp = n/2;
        int i = 3*(temp/2);
        if(temp%2==1)i++;
        return arr.get(n-i);
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> arr = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr.add(Integer.parseInt(token));
            }

            Solution obj = new Solution();
            int res = obj.rotateDelete(arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends
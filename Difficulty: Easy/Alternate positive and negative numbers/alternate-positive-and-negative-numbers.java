//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        int n = arr.size();
        ArrayList<Integer> pos = new ArrayList<>(n/2);
        ArrayList<Integer> neg = new ArrayList<>(n/2);
        
        for(int val: arr){
            if(val<0){
                neg.add(val);
            }else{
                pos.add(val);
            }
        }
        
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < pos.size() && j < neg.size()){
            arr.set(k++, pos.get(i++));
            arr.set(k++, neg.get(j++));
        }
        while(i < pos.size()){
            arr.set(k++, pos.get(i++));
        }
        while(j < neg.size()){
            arr.set(k++, neg.get(j++));
        }
    }
}
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        // Create a HashMap to store the frequency of each element
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Create a list of pairs (frequency, element)
        List<Map.Entry<Integer, Integer>> freqList = new ArrayList<>(freqMap.entrySet());

        // Sort the list based on frequency and then by element value if frequencies are equal
        Collections.sort(freqList, (a, b) -> {
            if (b.getValue().equals(a.getValue())) {
                return a.getKey() - b.getKey();
            }
            return b.getValue() - a.getValue();
        });

        // Create the result list by repeating elements according to their frequency
        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqList) {
            int frequency = entry.getValue();
            int element = entry.getKey();
            for (int i = 0; i < frequency; i++) {
                result.add(element);
            }
        }

        return result;
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends
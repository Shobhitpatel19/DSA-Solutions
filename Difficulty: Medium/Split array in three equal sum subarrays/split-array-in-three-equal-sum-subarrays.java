//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1) {
                System.out.println("false");
            } else {
                int sum1 = 0, sum2 = 0, sum3 = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (i <= result.get(0))
                        sum1 += arr[i];

                    else if (i <= result.get(1))
                        sum2 += arr[i];

                    else
                        sum3 += arr[i];
                }
                if (sum1 == sum2 && sum2 == sum3) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    public List<Integer> findSplit(int[] arr) {
        // Return an array of possible answer, driver code will judge and return true or
        // false based on
        List<Integer> result = new ArrayList<>();
        int totalSum = 0;

        // Calculate total sum of the array
        for (int num : arr) {
            totalSum += num;
        }

        // If the total sum is not divisible by 3, it's impossible to split
        if (totalSum % 3 != 0) {
            result.add(-1);
            result.add(-1);
            return result;
        }

        int targetSum = totalSum / 3;
        int currentSum = 0;
        int partitions = 0;
        int firstSplitIndex = -1;
        int secondSplitIndex = -1;

        // Traverse the array and find the split points
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            // When we find one partition with the target sum
            if (currentSum == targetSum) {
                partitions++;
                currentSum = 0;

                // Save the indices for the first and second split
                if (partitions == 1) {
                    firstSplitIndex = i;
                } else if (partitions == 2) {
                    secondSplitIndex = i;
                    break;  // Exit the loop early once we find two splits
                }
            }
        }

        // Check if we found exactly 2 partitions and thus 3 subarrays
        if (partitions == 2) {
            result.add(firstSplitIndex);
            result.add(secondSplitIndex);
        } else {
            result.add(-1);
            result.add(-1);
        }

        return result;
    }
}
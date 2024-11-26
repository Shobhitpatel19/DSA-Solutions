//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : arr) {
            if (!pq.contains(val)) {
                if (pq.size() < 2) {
                    pq.offer(val);
                } else if (pq.peek() < val) {
                    pq.poll();
                    pq.offer(val);
                }
            }
        }
        if (pq.size() < 2) {
            return -1;
        }
        return pq.poll();
    }
}
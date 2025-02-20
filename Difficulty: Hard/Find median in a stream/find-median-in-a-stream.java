//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends



class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> result = new ArrayList<>();

        // Max heap for left half (lower numbers)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Min heap for right half (higher numbers)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            // Directly decide where to put the number
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            // Balance the heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            // Calculate the median
            if (maxHeap.size() == minHeap.size()) {
                result.add(Double.valueOf((maxHeap.peek() + minHeap.peek()) / 2.0));
            } else {
                result.add(Double.valueOf(maxHeap.peek()));
            }
        }

        return result;
    }
}


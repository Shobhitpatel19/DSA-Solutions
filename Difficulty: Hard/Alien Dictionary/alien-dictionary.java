//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());

            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, n, k);
            if (order.length() == 0) {
                System.out.println(0);
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2 && a.length() != b.length()) {
                        if (a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }

                    if (index1 < index2)
                        return -1;
                    else
                        return 1;
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public String findOrder(String[] dict, int n, int k) {
        // Topological Sort using BFS
        List<Integer>[] adj = new ArrayList[k];
        int[] indeg = new int[k];
        
        // Initialize adjacency list
        for (int i = 0; i < k; i++) {
            adj[i] = new ArrayList<>();
        }
        
        // Build the graph
        for (int i = 0; i < n - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            boolean foundDifference = false;
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj[s1.charAt(j) - 'a'].add(s2.charAt(j) - 'a');
                    indeg[s2.charAt(j) - 'a']++;
                    foundDifference = true;
                    break;
                }
            }
            // If no difference is found and s2 is a prefix of s1, then the order is invalid.
            if (!foundDifference && s2.length() < s1.length()) {
                return "";
            }
        }
        
        // Perform topological sort using BFS
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (indeg[i] == 0) q.add(i);
        }
        
        StringBuilder ans = new StringBuilder();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.append((char)(node + 'a'));
            for (int i : adj[node]) {
                indeg[i]--;
                if (indeg[i] == 0) q.add(i);
            }
        }
        
        // If the length of the result string is less than k, that means a cycle exists.
        if (ans.length() != k) {
            return "";
        }
        
        return ans.toString();
    }
}

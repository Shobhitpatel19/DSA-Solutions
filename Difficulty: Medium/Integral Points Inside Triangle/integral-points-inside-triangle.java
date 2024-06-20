//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            long p[] = new long[2];
            long q[] = new long[2];
            long r[] = new long[2];
            p[0] = Long.parseLong(S[0]);
            p[1] = Long.parseLong(S[1]);
            q[0] = Long.parseLong(S[2]);
            q[1] = Long.parseLong(S[3]);
            r[0] = Long.parseLong(S[4]);
            r[1] = Long.parseLong(S[5]);
            Solution ob = new Solution();
            long ans = ob.InternalCount(p, q, r);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    // Method to calculate the greatest common divisor (GCD)
    public long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Method to calculate boundary points between two coordinates (x1, y1) and (x2, y2)
    public long boundPts(long x1, long y1, long x2, long y2) {
        if (x1 == x2) {
            return Math.abs(y1 - y2) - 1;
        }
        if (y1 == y2) {
            return Math.abs(x1 - x2) - 1;
        }
        return gcd(Math.abs(x1 - x2), Math.abs(y1 - y2)) - 1;
    }

    // Method to calculate the number of internal lattice points within a triangle
    public long InternalCount(long[] p, long[] q, long[] r) {
        // Code Here
        long bound = boundPts(p[0], p[1], q[0], q[1]) + boundPts(p[0], p[1], r[0], r[1]) +
                     boundPts(q[0], q[1], r[0], r[1]) + 3;
        long area = Math.abs(p[0] * (q[1] - r[1]) + q[0] * (r[1] - p[1]) + r[0] * (p[1] - q[1]));
        return (area - bound + 2) / 2;
    }
}



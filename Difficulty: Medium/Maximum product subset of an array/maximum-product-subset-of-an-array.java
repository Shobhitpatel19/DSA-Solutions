//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public long findMaxProduct(List<Integer> arr) {
        // code here
        int n = arr.size();
        long ans = 1;
        int mod = (int)1e9 + 7;
        int mn = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int num = arr.get(i);
            if (num == 0) continue;
            if (num < 0) {
                mn = Math.max(mn, num);
            }
            ans = (ans * num) % mod;
        }

        if (ans < 0) return ans / mn;
        return ans;
    }
}


//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;


// } Driver Code Ends
class Solution {
    class Pair{
        int f;
        int l;
        
        Pair(int f, int l){
            this.f = f;
            this.l = l;
        }
        
        Pair(){}
    }
    public int maxDistance(int[] arr) {
        // Code here
        HashMap<Integer, Pair> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            int key = arr[i];
            
            if(map.containsKey(key)){
                Pair temp = map.get(key);
                temp.l = i;
                
                map.put(key, temp);
            }else{
                Pair temp = new Pair(i,-1);
                map.put(key, temp);
            }
        }
        
        // System.out.println(map);
        
        int maxD = -1;
        for(Map.Entry<Integer, Pair> entry: map.entrySet()){
            Pair val = entry.getValue();
            if(val.f == -1 || val.l == -1) continue;
            int currD = val.l - val.f;
            if(currD > maxD){
                maxD = currD;
            }
        }
        return maxD;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxDistance(arr));
        }
        sc.close();
    }
}
// } Driver Code Ends
import java.util.Arrays;
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        
        Arrays.sort(happiness);
        
        int count = 0;
        long sum = 0;
        for(int j=n-1; j>=0; j--){
            if(k>0 && (happiness[j]-count)>0){
                sum = sum+happiness[j]-count;
            }
            k--;
            count++;
        }
        return sum;
    }
}
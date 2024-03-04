class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        for(int i = 0 ; i < spells.length; i++){
            int left = 0;
            int right = potions.length-1;
            while(left <= right){
                int mid = (left+right)/2;
                if((long)spells[i]*potions[mid] < success){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
            ans[i] = potions.length-right-1;
        }
        return ans;
    }
}
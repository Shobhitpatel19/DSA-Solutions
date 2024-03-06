class Solution {
    public boolean canEatBananas(int[] piles, int mid, int hour){
        int time = 0;
        for(int val: piles){
            time += val/mid;
            if(val%mid != 0){
                time++;
            }
        }
        return time <= hour;
    }
    public int minEatingSpeed(int[] piles, int h) {
        // low and high are the count of bananas per hour.
        int low = 1;
        int high = 0;

        // This loop is setting high = maximum value in piles
        for(int val: piles){
            if(val > high){
                high = val;
            }
        }

        while(low < high){
            int mid = low + (high-low)/2;

            if(canEatBananas(piles, mid, h)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}
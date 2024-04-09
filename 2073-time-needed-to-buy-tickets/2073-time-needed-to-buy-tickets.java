class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time_needed = 0;
        
        for(int i=0; i<tickets.length; i++){
            if(i<=k){
                time_needed += Math.min(tickets[k], tickets[i]);
            }else{
                time_needed += Math.min(tickets[k]-1, tickets[i]);
            }
        }
        return time_needed;
    }
}
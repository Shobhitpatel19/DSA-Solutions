class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        long ans = 0;
        int count=0, i=0, j= costs.length-1;

        while(count<k){
            while(pq1.size() < candidates && i<=j) pq1.offer(costs[i++]);
            while(pq2.size() < candidates && j>=i) pq2.offer(costs[j--]);

            int a = pq1.size()>0 ? pq1.peek() : Integer.MAX_VALUE;
            int b = pq2.size()>0 ? pq2.peek() : Integer.MAX_VALUE;

            if(a<=b){
                ans += a;
                pq1.poll();
            }else{
                ans += b;
                pq2.poll();
            }
            count++;
        }
        return ans;
    }
}
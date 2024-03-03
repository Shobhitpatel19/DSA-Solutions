class Solution {
    public class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        ArrayList<Pair> list = new ArrayList<Pair>(n);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long ksum = 0;
        long result = 0;

        for(int i=0; i<n; i++){
            list.add(new Pair(nums1[i], nums2[i]));
        }

        Collections.sort(list, (a, b) -> b.second - a.second);
        
        for(int i=0; i<k; i++){
            ksum += list.get(i).first;
            pq.offer(list.get(i).first);
        }

        result = ksum * list.get(k-1).second;

        for(int i=k; i<n; i++){
            ksum += list.get(i).first - pq.poll();
            pq.offer(list.get(i).first);

            result = Math.max(result, ksum*list.get(i).second);
        }

        return result;
    }
}
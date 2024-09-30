class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hp = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> ds = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(int num: nums){
            hp.put(num,hp.getOrDefault(num,0)+1);
        }
        ds.addAll(hp.entrySet());
        int [] result = new int[k];
        for(int i=0;i<k;i++){
            Map.Entry<Integer,Integer> sample = ds.peek();
            result[i] = sample.getKey();
            ds.remove(sample);
        }
        return result;
    }
}
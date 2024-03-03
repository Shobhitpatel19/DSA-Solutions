class SmallestInfiniteSet {
    int curr;
    Set<Integer> set;
    
    public SmallestInfiniteSet() {
        curr = 1;
        set = new HashSet<>();
    }
    
    public int popSmallest() {
        if(!set.isEmpty()){
            int res = Collections.min(set);
            set.remove(res);
            return res;
        }else{
            curr++;
            return curr-1;
        }
    }
    
    public void addBack(int num) {
        if(curr > num){
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int countzeroes = 0;
        for(int val: arr){
            set.add(2*val);
            if(val == 0){
                countzeroes++;
            }
        }

        if(countzeroes > 1) return true;
        for(int val: arr){
            if(val != 0 && set.contains(val)){
                return true;
            }
        }
        return false;
    }
}
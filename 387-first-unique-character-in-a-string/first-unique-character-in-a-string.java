class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for(char ch: s.toCharArray()){
            arr[ch - 'a']++;
        }

        for(int i=0; i<s.length(); i++){
            int currcharfreq = arr[s.charAt(i) - 'a'];
            if(currcharfreq == 1){
                return i;
            }
        }
        return -1;
    }
}
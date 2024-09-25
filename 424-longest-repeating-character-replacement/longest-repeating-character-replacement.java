class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int maxf = 0;
        int l = 0;
        int r = 0;
        int res = 0;

        while(r < n){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, map.get(s.charAt(r)));

            int size = r-l+1;
            if(size-maxf > k){
                int lf = map.get(s.charAt(l));
                lf--;
                map.put(s.charAt(l), lf);
                l++;
            }
            res = Math.max(res, r-l+1);
            r++;
        }
        return res;
    }
}
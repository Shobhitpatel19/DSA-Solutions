class Solution {
    public int prefixCount(String[] words, String pref) {
        int n = words.length;
        int k = pref.length();
        int count = 0;

        for(int i=0; i<n; i++) {
            String str = words[i];
            words[i] = k <= str.length() ? str.substring(0, k) : "";
        }

        for(String str: words){
            if(str.equals(pref)) count++;
        }
        return count;
    }
}
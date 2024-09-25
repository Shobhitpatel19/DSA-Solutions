class Solution {
    public String generateWord(String word){
        int[] fmap = new int[26];
        StringBuilder new_word = new StringBuilder();

        for(char ch: word.toCharArray()){
            fmap[ch-'a']++;
        }

        for(int i=0; i<26; i++){
            if(fmap[i] > 0){
                char ch = (char)(i + 'a');
                int count = fmap[i];
                new_word.append(String.valueOf(ch).repeat(count));
            }
        }
        return new_word.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // Write your code here
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        int n = strs.length;

        for(int i=0; i<n; i++){
            String word = strs[i];

            String new_word = generateWord(word);
            if(map.containsKey(new_word)){
                ArrayList<String> value = map.get(new_word);
                value.add(word);
                map.put(new_word, value);
            }else{
                ArrayList<String> value = new ArrayList<>();
                value.add(word);
                map.put(new_word, value);
            }
        }
        
        for(List<String> list: map.values()){
            res.add(list);
        }
        return res;
    }
}

/*
TC = O(nk), where n is the length of the string array and k is the maximum length of any word in the array
Sc = (n)
*/ 
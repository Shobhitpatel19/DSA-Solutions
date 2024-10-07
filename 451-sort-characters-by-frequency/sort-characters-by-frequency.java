class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        ArrayList<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry: entryList){
            char ch = entry.getKey();
            int count = entry.getValue();

            while(count != 0){
                sb.append(ch);
                count--;
            }
        }

        return sb.toString();
    }
}
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        int n = names.length;
        for(int i=0; i<n; i++){
            map.put(heights[i], names[i]);
        }

        // Converting map keys to an array
        //Integer[] keysArray = map.keySet().toArray(new Integer[0]);

        // Converting map values to an array
        String[] valuesArray = map.values().toArray(new String[0]);
        return valuesArray;
    }
}
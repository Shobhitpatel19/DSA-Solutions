class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        
        int[] arr = new int[2];
        // arr[0] represents the number students liking 0 sandwich.
        // arr[1] represents the number students liking 1 sandwich.
        
        Arrays.fill(arr ,0);
        
        for(int val: students){
            arr[val]++;
        }
        
        for(int i=0; i<n; i++){
            int sand = sandwiches[i];
            
            if(arr[sand] == 0){
                return n-i;
            }
            
            arr[sand]--;
        }
        return 0;
    }
}
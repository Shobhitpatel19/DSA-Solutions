class Solution {
    public int maxDepth(String s) {
        if(s.equals("")) return 0;
        
        int n = s.length();
        int depth = 0;
        int res = 0;
        
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '('){
                depth++;
            }else if(s.charAt(i) == ')'){
                depth--;
            }
            
            res = Math.max(depth, res);
        }
        return res;
    }
}
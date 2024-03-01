class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1'){
                count++;
            }
        }

        for(int i=0; i<n; i++){
            if(i == n-1){
                sb.append('1');
            }else if(count>1){
                sb.append('1');
                count--;
            }else{
                sb.append('0');
            }
        }
        return sb.toString();
    }
}
class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        for(int g=0; g<s.length(); g++){
            for(int i=0, j=g; j<dp.length; i++,j++){
                if(g==0){
                    dp[i][j] = true;
                    start = i;
                    end = j;
                }else if(g==1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                        start = i;
                        end = j;
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j] = true;
                        start = i;
                        end = j;
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int maxscore = 0;
        int score = 0;
        int i = 0;
        int j = tokens.length-1;
        
        Arrays.sort(tokens);
        
        while(i<=j){
            if(power >= tokens[i]){
                power -= tokens[i++];
                maxscore = Math.max(maxscore, ++score);
            }else if(score > 0){
                power += tokens[j--];
                score--;
            }else{
                break;
            }
        }
        return maxscore;
    }
}
class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");
        int n = arr.length;

        for(int i=0; i<n-1; i++){
            String stri = arr[i];
            String strj = arr[i+1];

            if(stri.charAt(stri.length()-1) != strj.charAt(0)){
                return false;
            }
        }
        String lastword = arr[arr.length-1];
        String firstword = arr[0];
        if(lastword.charAt(lastword.length() - 1) != firstword.charAt(0)){
            return false;
        }
        return true;
    }
}
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        String str = Integer.toString(x);
        int n = str.length();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if(n%2 == 0){
            // even case --> 1221
            int mid = n/2;
            sb1.append(str.substring(0, mid));
            sb2.append(str.substring(mid, n)).reverse();

        }else{
            // odd case --> 121
            int mid = n/2;
            sb1.append(str.substring(0, mid+1));
            sb2.append(str.substring(mid, n)).reverse();
        }

        return sb1.toString().equals(sb2.toString());
    }
}
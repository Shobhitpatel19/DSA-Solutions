class Solution {

    public double helper(double a,long n){
        if(a == 0 || n == 1) return a;
        if(n == 0) return 1;

        if(n<0){
            n = -n;
            a = 1.0/a;
        }
        return ((n%2 == 0)? helper(a*a,n/2) : helper(a*a,n/2)*a);
    }

    public double myPow(double x, int n) {
        long N = n;
        double ans = helper(x,N);
        return ans;
    }
}
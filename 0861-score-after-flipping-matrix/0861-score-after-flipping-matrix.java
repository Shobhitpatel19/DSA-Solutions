class Solution {
    public int matrixScore(int[][] A) {
    int r = A.length;
    int c = A[0].length;
    int res = 0;
    for(int i = 0; i < r; i++){
        if(A[i][0] != 0) continue;

        for(int j = 0; j < c; j++){
            A[i][j] = 1- A[i][j];
        }
    }
    res = r * (1 << (c -1));
    for(int i = 1; i < c ; i++){
        int t = 0;
        for(int j = 0; j < r; j++){
            if(A[j][i] == 1) t++;
        }
        t = Math.max(t, r - t);
        res += t * (1 << (c - i - 1));
    }
    return res;
}
}
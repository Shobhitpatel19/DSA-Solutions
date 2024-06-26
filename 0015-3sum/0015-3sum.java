class Solution {

    private void twoSumPairs(int[] a, int beg, int end, int fix, List<List<Integer>> ans) {
        int l = beg, r = end;
        while(l < r) {
            if(fix + a[l] + a[r] == 0) {
                ans.add(Arrays.asList(a[l], a[r], fix));
                l++;
                r--;

                //skip dublicates
                while(l < r && a[l] == a[l - 1]) l++;
                while(l < r && a[r] == a[r + 1]) r--;
            } else if(fix + a[l] + a[r] < 0) {
                l++;
            } else {
                r--;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] a) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(a); //O(n log n)

        for(int i = 0; i < a.length - 1; i++) {
            //to Avoid Duplicates
            if(i > 0 && a[i] == a[i - 1]) continue;

            twoSumPairs(a, i + 1, a.length - 1, a[i], ans);
        }

        return ans;
    }
}
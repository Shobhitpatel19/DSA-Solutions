class Solution {
    public int compareVersion(String version1, String version2) {
        String v1s[] = version1.split("\\.");
        String v2s[] = version2.split("\\.");

        int maxLen = Math.max(v1s.length, v2s.length);
        int v1;
        int v2;

        for (int i = 0; i < maxLen; i ++) {
            if (i < v1s.length) v1 = Integer.valueOf(v1s[i]);
            else v1 = 0;
            if (i < v2s.length) v2 = Integer.valueOf(v2s[i]);
            else v2 = 0;

            if (v1 > v2) return 1;
            else if (v1 < v2) return -1;
        }

        return 0;
    }
}
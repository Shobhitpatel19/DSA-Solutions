class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        // Add elements of nums1 to set1
        for (int num : nums1) {
            set1.add(num);
        }

        // Check for intersection while iterating through nums2
        for (int num : nums2) {
            if (set1.contains(num)) {
                intersect.add(num);
            }
        }

        // Convert HashSet to array
        int[] result = new int[intersect.size()];
        int index = 0;
        for (int num : intersect) {
            result[index++] = num;
        }

        return result;
    }
}
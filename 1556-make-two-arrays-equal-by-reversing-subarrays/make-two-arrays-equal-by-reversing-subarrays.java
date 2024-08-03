class Solution {
    public boolean canBeEqual(int[] targetArray, int[] currentArray) {
        if (targetArray.length != currentArray.length) {
            return false;
        }

        int[] elementCounts = new int[1001]; // We use 1001 because numbers range from 1 to 1000

        for (int i = 0; i < targetArray.length; i++) {
            elementCounts[targetArray[i]]++;
            elementCounts[currentArray[i]]--;
        }

        for (int count : elementCounts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
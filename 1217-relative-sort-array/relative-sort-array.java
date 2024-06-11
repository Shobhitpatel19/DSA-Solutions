class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Create a map to store the index of each element in arr2
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        // Mark elements not in arr2 with a large value (to be sorted at the end)
        int largeValue = 1000000000; // 1e9 equivalent in Java
        for (int i = 0; i < arr1.length; i++) {
            if (!map.containsKey(arr1[i])) {
                map.put(arr1[i], largeValue);
            }
        }

        // Define the comparator using a lambda expression
        Comparator<Integer> comparator = (num1, num2) -> {
            int index1 = map.get(num1);
            int index2 = map.get(num2);
            if (index1 == index2) {
                return Integer.compare(num1, num2);
            }
            return Integer.compare(index1, index2);
        };

        // Convert arr1 to a list for sorting
        List<Integer> arr1List = new ArrayList<>();
        for (int num : arr1) {
            arr1List.add(num);
        }

        // Sort the list using the defined comparator
        Collections.sort(arr1List, comparator);

        // Convert the sorted list back to an array
        int[] sortedArray = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            sortedArray[i] = arr1List.get(i);
        }

        return sortedArray;
    }
}
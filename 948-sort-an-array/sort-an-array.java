class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n-1);
        return nums;
    }

    public void mergeSort(int[] nums, int low, int high){
        if(low < high){
            int mid = low + (high - low)/2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid+1, high);
            merge(nums, low, mid, high);
        }
    }

    public void merge(int[] nums, int l, int m, int h){
        int n1 = m - l + 1;
        int n2 = h - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++)
            left[i] = nums[l + i];

        for (int i = 0; i < n2; i++)
            right[i] = nums[m + 1 + i];

        int k = l;
        int i = 0;
        int j = 0;

        while(i < n1 && j < n2){
            if(left[i] < right[j]){
                nums[k] = left[i];
                i++;
                k++;
            }else if(left[i] > right[j]){
                nums[k] = right[j];
                k++;
                j++;
            }else{
                nums[k] = left[i];
                i++;
                k++;
            }
        }

        while(i < n1){
            nums[k] = left[i];
            k++;
            i++;
        }
        while(j < n2){
            nums[k] = right[j];
            k++;
            j++;
        }
    }
}
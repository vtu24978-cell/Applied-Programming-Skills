import java.util.*;

class Solution {
    private int[] counts;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        counts = new int[n];

        int[][] arr = new int[n][2]; // [value, index]
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        mergeSort(arr, 0, n - 1);

        List<Integer> result = new ArrayList<>();
        for (int c : counts) {
            result.add(c);
        }

        return result;
    }

    private void mergeSort(int[][] arr, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private void merge(int[][] arr, int left, int mid, int right) {
        List<int[]> temp = new ArrayList<>();

        int i = left, j = mid + 1;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (arr[j][0] < arr[i][0]) {
                temp.add(arr[j]);
                rightCount++;
                j++;
            } else {
                counts[arr[i][1]] += rightCount;
                temp.add(arr[i]);
                i++;
            }
        }

        while (i <= mid) {
            counts[arr[i][1]] += rightCount;
            temp.add(arr[i]);
            i++;
        }

        while (j <= right) {
            temp.add(arr[j]);
            j++;
        }

        for (int k = left; k <= right; k++) {
            arr[k] = temp.get(k - left);
        }
    }
}
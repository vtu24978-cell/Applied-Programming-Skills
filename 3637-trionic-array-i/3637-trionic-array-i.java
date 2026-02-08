class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int i = 0;

        // 1) strictly increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == 0 || i == n - 1) return false; // must increase at least once

        // 2) strictly decreasing
        while (i + 1 < n && nums[i] > nums[i + 1]) {
            i++;
        }
        if (i == n - 1) return false; // must decrease at least once

        // 3) strictly increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }

        // must reach the end
        return i == n - 1;
    }
}

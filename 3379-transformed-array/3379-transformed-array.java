class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                int idx = i + nums[i];
                idx = ((idx % n) + n) % n; // handle circular wrap
                result[i] = nums[idx];
            }
        }

        return result;
    }
}

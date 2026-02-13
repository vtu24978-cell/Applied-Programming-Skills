class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int[] lastIndex = new int[256];
        java.util.Arrays.fill(lastIndex, -1);

        int left = 0; 

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            if (lastIndex[ch] >= left) {
                left = lastIndex[ch] + 1;
            }

            lastIndex[ch] = right;
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}

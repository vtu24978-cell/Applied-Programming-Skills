class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long MIN = Long.MIN_VALUE / 2;

        // s1: max sum of a strictly increasing subarray [l...p]
        // s2: max sum of a trionic prefix ending in decreasing [l...q]
        // s3: max sum of a full trionic subarray [l...r]
        long s1 = MIN, s2 = MIN, s3 = MIN;
        long maxSum = MIN;

        for (int i = 0; i < n; i++) {
            long cur = nums[i];
            
            if (i > 0) {
                long prev = nums[i - 1];
                
                // Temporary variables to hold updates for this index
                long nextS1 = MIN;
                long nextS2 = MIN;
                long nextS3 = MIN;

                // 1. Strictly Increasing (Up)
                if (cur > prev) {
                    // Start a new pair or extend existing s1
                    nextS1 = Math.max(prev + cur, s1 + cur);
                    
                    // Extend a completed Down-Up sequence (s3)
                    if (s3 != MIN) {
                        nextS3 = Math.max(nextS3, s3 + cur);
                    }
                    // Transition from Down to Up (s2 -> s3)
                    if (s2 != MIN) {
                        nextS3 = Math.max(nextS3, s2 + cur);
                    }
                } 
                
                // 2. Strictly Decreasing (Down)
                if (cur < prev) {
                    // Transition from Up to Down (s1 -> s2)
                    if (s1 != MIN) {
                        nextS2 = Math.max(nextS2, s1 + cur);
                    }
                    // Extend existing Down sequence (s2)
                    if (s2 != MIN) {
                        nextS2 = Math.max(nextS2, s2 + cur);
                    }
                }

                s1 = nextS1;
                s2 = nextS2;
                s3 = nextS3;
            }
            
            maxSum = Math.max(maxSum, s3);
        }

        return maxSum;
    }
}
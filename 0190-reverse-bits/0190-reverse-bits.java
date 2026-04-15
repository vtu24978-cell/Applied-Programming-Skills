class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int lastBit = n & 1;      // extract last bit
            result = result << 1;     // shift result
            result = result | lastBit; // add bit
            n = n >> 1;              // shift input
        }

        return result;
    }
}
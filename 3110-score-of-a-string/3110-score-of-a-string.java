class Solution {
    public int scoreOfString(String s) {
        int ans =0;
        for(int i=0;i<s.length()-1;i++){
            int a =i;
            int b = i+1;
            int first = s.charAt(a);
            int second =s.charAt(b);
            int aascii = first;
            int bascii = second;
            int temp = Math.abs(aascii - bascii);
            ans = ans+temp;
        }
        return ans;
        
    }
}
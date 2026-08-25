class Solution {
    public int[] replaceElements(int[] arr) {
       int n = arr.length;
       for(int i=0;i<n;i++){
        int rightmax =-1;
        for(int j=i+1;j<n;j++){
            rightmax = Math.max(arr[j],rightmax);
        }
        arr[i] = rightmax;
       }
       return arr;
    }
}
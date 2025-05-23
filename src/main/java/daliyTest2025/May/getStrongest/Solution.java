package daliyTest2025.May.getStrongest;

import java.util.Arrays;

class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int m = arr[(n-1)/2];
        int l = 0, r = n - 1;
        int[] ans = new int[k];
        for(int i = 0;i<k;i++){
            if(Math.abs(arr[r] - m) >= Math.abs(arr[l] - m)){
                ans[i] = arr[r];
                r -= 1;
            }else {
                ans[i] = arr[l];
                l += 1;
            }
        }
        return ans;
    }
}

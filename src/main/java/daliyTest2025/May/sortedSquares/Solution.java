package daliyTest2025.May.sortedSquares;

import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int r = n-1, l = 0;
        for(int i = n-1;i>=0;i--){
            int x = nums[l]*nums[l], y = nums[r] * nums[r];
            if(x <= y){
                ans[i] = y;
                r -= 1;
            }else{
                ans[i] = x;
                l += 1;
            }
        }
        return ans;
    }
}

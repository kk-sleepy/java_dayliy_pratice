package daliyTest2025.May;

import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rob(new int[]{1,2,3,1}));;
    }
}

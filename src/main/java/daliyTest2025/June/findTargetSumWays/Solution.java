package daliyTest2025.June.findTargetSumWays;

import java.util.Arrays;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums)
            sum += x;
        int s = (sum - Math.abs(target));
        if(s < 0 || s % 2 == 1)
            return 0;
        s = s / 2;
        int[][] dp = new int[n+1][s+1];
        dp[0][0] = 1;
        for(int i = 1;i<=n;i++){
            for(int j = 0;j<=s;j++){
                if(j >= nums[i-1]){
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][s];
    }
}
package daliyTest2025.May.rob213;

import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(nums[0] + dfs(2,n-1,nums),dfs(1,n,nums));
    }
    int dfs(int i,int j,int[] nums){
        if(j<=i)
            return 0;
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[i+1] = Math.max(nums[i],nums[i+1]);
        dp[i] = nums[i];
        for(int k = i+2;k<j;k++){
            dp[k] = Math.max(dp[k-1],dp[k-2]+nums[k]);
        }
        return dp[j-1];
    }
}

package daliyTest2025.May;

import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        return dfs(0,nums.length,nums);
    }
    int dfs(int i,int j,int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        dp[i] = nums[0];
        dp[i+1] = Math.max(nums[i],nums[i+1]);
        for(int k = i+2;k<j;k++){
            dp[k] = Math.max(dp[k-1],dp[k-2]+nums[k]);
        }
        return dp[j-1];
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rob(new int[]{1,2,3,1}));;
    }
}

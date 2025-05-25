package daliyTest2025.May.minCostClimbingStairs746;

import java.util.Arrays;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        for(int i = 2;i<=n;i++){
            dp[i] = Math.min(dp[i-2] + cost[i-2],dp[i-1]+cost[i-1]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}
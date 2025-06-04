package daliyTest2025.June.findTargetSumWays;

import java.util.Arrays;

class Solution {
    int[][] memo;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums)
            sum += x;
        int s = (sum - Math.abs(target));
        if(s < 0 || s % 2 == 1)
            return 0;
        s = s / 2;
        memo = new int[n][s+1];
        for(int i = 0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        return dfs(nums,n-1,s);
    }
    int dfs(int[] nums,int i,int s){
        if(i < 0)
            return s == 0 ? 1 : 0;
        if(s < 0){
            return 0;
        }
        if(memo[i][s] != -1)
            return memo[i][s];
        return memo[i][s] = dfs(nums,i-1,s-nums[i]) + dfs(nums,i-1,s);
    }
}
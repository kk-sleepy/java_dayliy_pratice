package daliyTest2025.Apr.canPartition;

import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        int res = 0,n = nums.length;
        for(int i=0;i<n;i++){
            res += nums[i];
        }
        if(res%2==1)
            return false;
        int mid = res / 2;
        int[][] dp = new int[n+1][mid+1];
        Arrays.fill(dp[0],mid);
        for(int i = 1;i<=n;i++){
            for(int j = 0;j<=mid;j++){
                int x = nums[i-1];
                if(j>=x){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-x]-x);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][mid] == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canPartition(new int[] {1,2,5}));
    }
}

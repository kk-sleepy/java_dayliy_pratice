package daliyTest2025.June.minPathSum64;

import java.util.Arrays;

class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n+1][m+1];
        Arrays.fill(dp[0],Integer.MAX_VALUE);
        dp[0][1] = 0;
        for(int i = 1;i<=n;i++){
            for(int j = 0;j<=m;j++){
                if(j == 0){
                    dp[i][j] = Integer.MAX_VALUE;
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}

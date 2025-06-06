package daliyTest2025.June.numberOfWays;

import java.util.Arrays;

class Solution {
    int m;
    int mod = 1_000_000_000 + 7;
    public int numberOfWays(int n, int x) {
        m = (int)Math.pow(n,1.0/x) + 1;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i = 1;i<=m;i++){
            for(int j = 0;j<=n;j++){
                int temp = (int)Math.pow(i,x);
                if(j < temp){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-temp]) % mod;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numberOfWays(4,1));
    }
}
package daliyTest2025.May.minDistance72;

import java.util.Arrays;

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int j = 1;j<=m;j++)
            dp[0][j] = j;
        for(int i = 0;i<n;i++){
            dp[i+1][0] = i;
            for(int j=0;j<m;j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }else{
                    dp[i+1][j+1] = 1  + Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i][j]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.minDistance("horse","ros");
    }
}

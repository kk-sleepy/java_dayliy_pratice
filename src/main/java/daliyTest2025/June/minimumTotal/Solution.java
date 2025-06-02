package daliyTest2025.June.minimumTotal;

import java.util.*;
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size(), m = triangle.get(n-1).size();
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<i+1;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = triangle.get(i).get(j);
                }else if(j == 0){
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                }else if(j == i){
                    dp[i][j] = dp[i-1][j-1] +  triangle.get(i).get(j);
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) +  triangle.get(i).get(j);
                }
                if(i == n-1){
                    ans = Math.min(ans,dp[i][j]);
                }
            }
        }
        return ans;
    }
}
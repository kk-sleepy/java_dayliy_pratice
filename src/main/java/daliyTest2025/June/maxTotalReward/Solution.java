package daliyTest2025.June.maxTotalReward;

import java.util.Arrays;

class Solution {
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        Arrays.sort(rewardValues);
        int m = rewardValues[n-1];
        boolean[][] dp = new boolean[n+1][2*m];
        dp[0][0] = true;
        for(int i = 0;i<n;i++){
            int v = rewardValues[i];
            for(int j = 0;j<2*m;j++){
                if(j>=v && j<2 * v){
                    dp[i+1][j] = dp[i][j] || dp[i][j-v];
                }else{
                    dp[i+1][j] = dp[i][j];;
                }
            }
        }
        int ans = 2 * m -1;
        while(!dp[n][ans]){
            ans -= 1;
        }
        return ans;
    }
}
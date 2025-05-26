package daliyTest2025.May.countHousePlacements2320;

import java.util.Arrays;

class Solution {
    final static int mod = 1000_000_000 + 7;
    public int countHousePlacements(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2;i<=n;i++){
            dp[i] = (dp[i-2]+dp[i-1]) % mod;
        }
        return (int)(((long) dp[n] * dp[n]) % mod);
    }
}

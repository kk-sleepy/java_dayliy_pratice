package daliyTest2025.May.countGoodStrings;

import java.util.Arrays;

class Solution {
    private static final int mod = 1_000_000_000 + 7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        dp[0] = 1;
        int ans = 0;
        for(int i = 1;i<=high;i++){
            int sum0 = 0, sum1 = 0;
            if(i>=zero){
                sum0 = dp[i-zero];
            }
            if(i>=one){
                sum1 = dp[i-one];
            }
            dp[i] = (sum1 + sum0) % mod;
        }
        for(int i = low;i<=high;i++){
            ans = (ans + dp[i]) % mod;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countGoodStrings(2,3,1,2));
    }
}

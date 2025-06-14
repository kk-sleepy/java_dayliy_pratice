package daliyTest2025.May.mostPoints2140;

class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n+1];
        for(int i = n-1;i>=0;i--){
            int j = Math.min(i+questions[i][1]+1,n);
            dp[i] = Math.max(dp[i+1],dp[j] + questions[i][0]);
        }
        return dp[0];
    }
}

package daliyTest2025.June.findMaxForm;

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] cnt = new int[len][2];
        for(int i = 0;i<len;i++){
            for(char c : strs[i].toCharArray()){
                cnt[i][c-'0'] += 1;
            }
        }
        int[][][] dp = new int[len+1][m+1][n+1];
        for(int i = 0;i<len;i++){
            int tm = cnt[i][0];
            int tn = cnt[i][1];
            for(int j = 0;j<=m;j++){
                for(int k = 0;k<=n;k++){
                    if(j<tm || k <tn){
                        dp[i+1][j][k] = dp[i][j][k];
                    }else{
                        dp[i+1][j][k] = Math.max(dp[i][j][k],dp[i][j-tm][k-tn]+1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }
}
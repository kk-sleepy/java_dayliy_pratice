package daliyTest2025.May.checkPartitioning1745;

public class Solution {
    public boolean checkPartitioning(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int len=1;len<n;len++){
            for(int start=0;start<=n-len;start++){
                int end = start + len -1;
                if(len==1){
                    dp[start][end] = true;
                }else if(len==2){
                    dp[start][end] = s.charAt(start)==s.charAt(end);
                }else{
                    dp[start][end] = (s.charAt(start)==s.charAt(end)) && (dp[start+1][end-1]);
                }
            }
        }
        for(int i=1;i<n-1;i++){
            if(!dp[0][i-1])
                continue;
            for(int j=i;j<n-1;j++){
                if(dp[i][j]&&dp[j+1][n-1])
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] arg){
        Solution s = new Solution();
        System.out.println(s.checkPartitioning("abcbdd"));
    }
}

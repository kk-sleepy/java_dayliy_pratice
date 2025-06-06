package daliyTest2025.June.numberOfWays;

import java.util.Arrays;

class Solution {
    int[][] memo;
    int m;
    int mod = 1_000_000_000 + 7;
    public int numberOfWays(int n, int x) {
        m = (int)Math.pow(n,1.0/x) + 1;
        memo = new int[m+1][n+1];
        for(int i = 0;i<=m;i++){
            Arrays.fill(memo[i],-1);
        }
        return dfs(m,n,x);
    }
    int dfs(int i,int target,int x){
        if(i <= 0){
            return target == 0 ? 1 : 0;
        }
        if(memo[i][target] != -1)
            return memo[i][target];
        int temp = (int)Math.pow(i,x);
        if(temp > target){
            return memo[i][target] = dfs(i-1,target,x);
        }

        return memo[i][target] = (dfs(i-1,target-temp,x) + dfs(i-1,target,x)) % mod;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numberOfWays(10,2));
    }
}
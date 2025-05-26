package daliyTest2025.May.countGoodStrings;

import java.util.Arrays;

class Solution {
    int zero;
    int one;
    int[] memo;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1_000_000_000 + 7;
        memo = new int[high+1];
        Arrays.fill(memo,-1);
        this.zero = zero;
        this.one = one;
        int mins = Math.min(zero,one);
        int maxs = Math.min(zero,one);
        memo[mins] = 1;
        for(int i = mins;i<=maxs;i++){
            if(i%mins==0){
                memo[i] = 1;
            }
        }
        memo[maxs] += 1;
        int ans = 0;
        for(int i = low;i<=high;i++){
            ans += dfs(i);
        }
        return ans;
    }
    int dfs(int i){
        if(i <= 0){
            return 0;
        }
        if(memo[i]!=-1){
            return memo[i];
        }
        int sum1 = 0, sum0 = 0;
        if(i >= zero){
            sum0 = dfs(i-zero);
        }
        if(i >= one){
            sum1 = dfs(i-one);
        }
        return memo[i] = sum0 + sum1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countGoodStrings(3,3,1,1));
    }
}

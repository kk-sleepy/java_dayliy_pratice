package daliyTest2025.June.lengthOfLongestSubsequence;

import java.util.Arrays;
import java.util.List;

class Solution {
    int[][] memo;
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        memo = new int[n][target+1];
        for(int i = 0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        int ans = dfs(nums,target,n-1);
        return ans>0 ? ans : -1;
    }
    int dfs(List<Integer> nums,int target,int i){
        if(i < 0){
            return target == 0 ? 0 : Integer.MIN_VALUE;
        }
        if(nums.get(i) > target){
            return memo[i][target] = dfs(nums,target,i-1);
        }
        if(memo[i][target] != -1)
            return memo[i][target];
        int x1 = dfs(nums,target-nums.get(i),i-1) + 1;
        return memo[i][target] = Math.max(x1,dfs(nums,target,i-1));
    }
}

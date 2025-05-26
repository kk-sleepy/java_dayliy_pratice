package daliyTest2025.May.combinationSum4;

import java.util.Arrays;

class Solution {
    int[] memo;
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        memo = new int[target+1];
        Arrays.fill(memo,-1);
        return dfs(nums,target);
    }
    int dfs(int[] nums,int j){
        if(j == 0)
            return 1;
        if(memo[j] != -1)
            return memo[j];
        int res = 0;
        for(int x : nums){
            if(j>=x){
                res += dfs(nums,j-x);
            }
        }
        return memo[j] = res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combinationSum4(new int[]{1,2,3},4));
    }
}
/**
 * 1 2 3
 * 4 5 6
 * 7 8 9
 */
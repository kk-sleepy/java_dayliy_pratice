package daliyTest2025.Apr.largestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums){
        int n = nums.length;
        int[] memo = new int [n], from = new int[n];
        Arrays.sort(nums);
        Arrays.fill(from,-1);
        int fMax = 0, iMax = 0;
        for(int i=0;i<n;i++){
            int f = dfs(i,nums,memo,from);
            if(f>fMax){
                fMax = f;
                iMax = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = iMax;i>=0;i = from[i]){
            ans.add(nums[i]);
        }
        return ans;
    }
    public int dfs(int i,int[] nums, int[] memo, int[] from){
        if(memo[i]>0){
            return memo[i];
        }
        int res = 0;
        for(int j=0;j<i;j++){
            if(nums[i]%nums[j]!=0){
                continue;
            }
            int f = dfs(j,nums,memo,from);
            if(f>res){
                res = f;
                from[i] = j;
            }
        }
        return memo[i] = res + 1;
    }
    public static  void main(String[] args){
        Solution s = new Solution();
        List<Integer> ans = s.largestDivisibleSubset(new int[] {1,2,3});
        for(Integer x : ans){
            System.out.print(x + " ");
        }
    }
}

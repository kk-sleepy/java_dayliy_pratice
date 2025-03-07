package daliyTest2025.May.beautifulSubsets2597;

import java.util.*;

public class Solution {
    private int n = 0;
    private int ans = 0;
    public int beautifulSubsets(int[] nums, int k){
        n = nums.length;
        Arrays.sort(nums);
        if(n<2)
            return n;
        Map<Integer,Integer> vis = new HashMap();
        dfs(vis,nums,0,k);
        return ans - 1;
    }
    public void dfs(Map<Integer,Integer> vis,int[] nums,int i,int k){
        if(i==n){
            ans += 1;
            return;
        }
        dfs(vis,nums,i+1,k);
        if((vis.getOrDefault(nums[i]-k,0)==0)&&(vis.getOrDefault(nums[i]+k,0)==0)){
            vis.put(nums[i],vis.getOrDefault(nums[i],0) + 1);
            dfs(vis,nums,i+1,k);
            vis.put(nums[i],vis.getOrDefault(nums[i],0) - 1);
        }
    }
    public static void main(String[] arg){
        Solution s = new Solution();
        int[] nums = {1,1,2,3};
        System.out.println(s.beautifulSubsets(nums,1));
    }
}

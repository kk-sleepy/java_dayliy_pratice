package daliyTest2025.Mar.twoSum1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> ans = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int x = ans.getOrDefault(target-nums[i],-1);
            if(x!=-1){
                return new int[] {x,i};
            }
            ans.put(nums[i],i);
        }
        return new int[0];
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] sums = {3,2,4};
        int[] data = s.twoSum(sums,6);
        for(int x:data){
            System.out.println(x);
        }
    }
}

package daliyTest2025.May.subarraySum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> cnt = new HashMap<>();
        int n = nums.length;
        int ans = 0;
        int[] idx = new int[n+1];
        for(int i=0;i<n;i++){
            idx[i+1] = nums[i] + idx[i];
        }
        for(int x:idx){
            ans += cnt.getOrDefault(x-k,0);
            cnt.merge(x,1,Integer::sum);
        }
        return ans;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {1,1,1};
        System.out.println(s.subarraySum(nums,2));
    }
}

package daliyTest2025.May.maxSubarrayLength2958;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int ans = 0,l = 0;
        Map<Integer,Integer> cnt = new HashMap<>();
        for(int i = 0;i<n;i++){
            cnt.merge(nums[i],1,Integer::sum);
            while(cnt.get(nums[i])>k){
                cnt.merge(nums[l],-1,Integer::sum);
                l += 1;
            }
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}
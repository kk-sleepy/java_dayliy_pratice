package daliyTest2025.May.countFairPairs2563;

import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0L;
        int n = nums.length;
        Arrays.sort(nums);
        int l = n-1, r = n - 1;
        for(int i = 0;i<n;i++){
            while(r > 0 && nums[r] > upper - nums[i]){
                r -= 1;
            }
            while(l > 0 && nums[l] >= lower - nums[i]){
                l -= 1;
            }
            ans += Math.min(r,i) - Math.min(l,i);
        }
        return ans;
    }
}
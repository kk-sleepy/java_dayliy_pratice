package daliyTest2025.May.purchasePlans28;

import java.util.Arrays;

class Solution {
    public int purchasePlans(int[] nums, int target) {
        int mod = 1000000007;
        int ans = 0;
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while(l<=r){
            int x = nums[l] + nums[r];
            if(x > target){
                r -= 1;
            }else{
                ans = (ans + r - l) % mod;
                l += 1;
            }
        }
        return ans;
    }
}

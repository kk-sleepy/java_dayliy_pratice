package daliyTest2025.May.maximumUniqueSubarray1695;

import java.util.Map;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[] cnt = new int[10005];
        int l = 0,temp = 0;
        for(int i=0;i<n;i++){
            temp += nums[i];
            cnt[nums[i]] += 1;
            while(cnt[nums[i]] > 1){
                cnt[nums[l]] -= 1;
                temp -= nums[l];
                l += 1;
            }
            ans = Math.max(temp,ans);
        }
        return ans;
    }
}

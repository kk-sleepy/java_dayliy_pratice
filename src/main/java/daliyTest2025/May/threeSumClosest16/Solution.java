package daliyTest2025.May.threeSumClosest16;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = 0,n = nums.length,diff = 100000;
        Arrays.sort(nums);
        for(int i = 0;i<n-2;i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            int x = nums[i];
            // 优化一
            int s = x + nums[i + 1] + nums[i + 2];
            if (s > target) { // 后面无论怎么选，选出的三个数的和不会比 s 还小
                if (s - target < diff) {
                    ans = s; // 由于下面直接 break，这里无需更新 minDiff
                }
                break;
            }
            // 优化二
            s = x + nums[n - 2] + nums[n - 1];
            if (s < target) { // x 加上后面任意两个数都不超过 s，所以下面的双指针就不需要跑了
                if (target - s < diff) {
                    diff = target - s;
                    ans = s;
                }
                continue;
            }
            int l = i + 1, r = n - 1;
            while (l<r){
                s = x + nums[l] + nums[r];
                if(s < target){
                    if(target - s < diff){
                        diff = target - s;
                        ans = s;
                    }
                    l += 1;
                }else if (s > target){
                    if(s - target < diff){
                        diff = s - target;
                        ans = s;
                    }
                    r -= 1;
                }else{
                    return s;
                }
            }
        }
        return ans;
    }
}

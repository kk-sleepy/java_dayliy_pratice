package daliyTest2025.Apr.countSubarrays2;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        int n = nums.length;
        int l = 0;
        int maxNum = 0;
        for (int i = 0; i < n; i++) {
            maxNum = Math.max(nums[i], maxNum);
        }
        int sum = 0;
        for (int r = 0; r < n; r++) {
            if (nums[r] == maxNum)
                sum += 1;
            while (sum >= k) {
                if(nums[l]==maxNum)
                    sum -= 1;
                l += 1;
            }
            ans += l;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 3, 2, 3, 3};
        int k = 2;
        System.out.println(s.countSubarrays(nums, k));
    }
}

package daliyTest2025.May.longestSubarray1493;

class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int l = 0, r = 0;
        while (r < n && nums[r] == 0)
            r += 1;
        l = r;
        int flag = 0;
        for (; r < n; r++) {
            if (nums[r] == 0) {
                int j = r + 1;
                while (j < n && nums[j] != 0) {
                    j += 1;
                }
                ans = Math.max(ans, j - l - 1);
                l = r + 1;
            }else{
                flag += 1;
                ans = Math.max(ans, r - l + 1);
            }
        }
        if(flag == n)
            return n - 1;
        return ans;
    }
}

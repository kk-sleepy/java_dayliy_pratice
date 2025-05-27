package daliyTest2025.May.maxAbsoluteSum1749;

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int mx = 0;
        int mn = 1;
        for(int i = 0;i<n;i++){
           mx = Math.max(mx,0) + nums[i];
           mn = Math.min(mn,0) + nums[i];
           ans = Math.max(ans,Math.max(mx,-mn));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxAbsoluteSum(new int[]{-7,-1,0,-2,1,3,8,-2,-6,-1,-10,-6,-6,8,-4,-9,-4,1,4,-9}));
    }
}
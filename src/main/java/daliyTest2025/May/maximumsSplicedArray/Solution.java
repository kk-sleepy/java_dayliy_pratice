package daliyTest2025.May.maximumsSplicedArray;

class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(maxSolve(nums1,nums2),maxSolve(nums2,nums1));
    }
    int maxSolve(int[] nums1, int[] nums2){
        int s1 = 0;
        int maxS = 0;
        int n = nums1.length;
        for(int x : nums1){
            s1 += x;
        }
        int[] dp = new int[n+1];
        for(int i = 0;i<n;i++){
            dp[i+1] = Math.max(dp[i],0) + nums2[i] - nums1[i];
            maxS = Math.max(maxS,dp[i+1]);
        }
        return s1 + maxS;
    }
}

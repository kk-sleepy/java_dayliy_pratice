package daliyTest2025.May.maxSubarraySumCircular;

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int minS = 0,maxS = Integer.MIN_VALUE;
        int mn = 0,mx = 0;
        int sum = 0;
        for(int x : nums){
            mn = Math.min(mn,0) + x;
            mx = Math.max(mx,0) + x;
            sum += x;
            maxS = Math.max(maxS,mx);
            minS = Math.min(minS,mn);
        }
        return sum == minS ? maxS : Math.max(maxS,sum - minS);
    }
}

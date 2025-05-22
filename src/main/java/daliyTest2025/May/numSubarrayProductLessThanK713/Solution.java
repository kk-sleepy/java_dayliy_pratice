package daliyTest2025.May.numSubarrayProductLessThanK713;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0, l = 0;
        int n = nums.length;
        int temp = 1;
        for(int i = 0;i<n;i++){
            temp *= nums[i];
            while(l<=i && temp >= k){
                temp /= nums[l];
                l += 1;
            }
            ans += i - l + 1;
        }
        return ans;
    }
}
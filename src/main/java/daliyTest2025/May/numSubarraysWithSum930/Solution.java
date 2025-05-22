package daliyTest2025.May.numSubarraysWithSum930;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarrays(nums,goal) - numSubarrays(nums,goal + 1);
    }
    private int numSubarrays(int[] nums,int goal){
        int ans = 0, l = 0,temp = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            temp += nums[i];
            while(l<=i && temp >= goal){
                temp -= nums[l];
                l += 1;
            }
            ans += l;
        }
        return ans;
    }
}
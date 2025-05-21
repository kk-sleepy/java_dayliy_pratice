package daliyTest2025.May.minSubArrayLen209;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, temp = 0,n = nums.length;
        int ans = n + 1;
        for(int i = 0;i<n;i++){
            temp += nums[i];
            while(temp >= target){
                temp -= nums[l];
                ans = Math.min(ans,i-l+1);
                l += 1;
            }
        }
        if(ans == n +1)
            return 0;
        return ans;
    }
}

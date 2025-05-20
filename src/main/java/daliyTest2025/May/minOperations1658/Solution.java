package daliyTest2025.May.minOperations1658;

class Solution {
    public int minOperations(int[] nums, int x) {
        int ans = -1, l = 0;
        int sum = 0, n = 0;
        for(int num : nums){
            sum += num;
            n += 1;
        }
        int target = sum - x;
        if(target < 0)
            return - 1;
        int temp = 0;
        for(int i = 0;i<n;i++){
            temp += nums[i];
            while(l<n && temp > target){
                temp -= nums[l];
                l += 1;
            }
            if(temp == target){
                ans = Math.max(ans,i - l + 1);
            }
        }
        return ans < 0 ? -1 : n - ans;
    }
}

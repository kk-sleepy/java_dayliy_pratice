package daliyTest2025.May.longestOnes1004;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0, l = 0;
        int n = nums.length;
        int temp = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] == 0){
                temp += 1;
            }
            while(temp > k){
                if(nums[l] == 0)
                    temp -= 1;
                l += 1;
            }
            ans = Math.max(ans,i - l + 1);
        }
        return ans;
    }
}

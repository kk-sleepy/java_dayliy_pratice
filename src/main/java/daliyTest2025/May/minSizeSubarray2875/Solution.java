package daliyTest2025.May.minSizeSubarray2875;

class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        long total = 0;
        int ans = Integer.MAX_VALUE;
        for(int x : nums)
            total += x;
        int n = nums.length;
        int l = 0, temp = 0;
        for(int i=0;i<2*n;i++){
            temp += nums[i%n];
            while(temp>=target % total){
                if(temp == target % total){
                    ans = Math.min(ans,i - l + 1);
                }
                temp -= nums[l%n];
                l += 1;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans + (int) (target / total) * n;
    }
    //{9,2,9,2}
}

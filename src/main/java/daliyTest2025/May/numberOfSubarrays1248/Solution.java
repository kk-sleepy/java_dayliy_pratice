package daliyTest2025.May.numberOfSubarrays1248;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return count(nums,k) - count(nums,k+1);
    }
    private int count(int[] nums, int k){
        int ans = 0, l = 0;
        int n = nums.length, temp = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] % 2 == 1)
                temp += 1;
            while (l<=i && temp>=k){
                if(nums[l] % 2 == 1)
                    temp -= 1;
                l += 1;
            }
            ans += l;
        }
        return ans;
    }
}

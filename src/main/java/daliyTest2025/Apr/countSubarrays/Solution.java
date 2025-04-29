package daliyTest2025.Apr.countSubarrays;

public class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0;
        int l = 0;
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while(sum*(i-l+1)>=k){
                sum -= nums[l];
                l += 1;
            }
            ans += i - l + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{2, 1, 4, 3, 5};
        long k = 10;
        System.out.println(s.countSubarrays(nums, k));
    }
}

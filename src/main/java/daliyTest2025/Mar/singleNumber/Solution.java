package daliyTest2025.Mar.singleNumber;

public class Solution {
    public int singleNumber(int[] nums){
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans ^= nums[i];
        }
        return ans;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {2,2,1};
        System.out.println(s.singleNumber(nums));
    }
}

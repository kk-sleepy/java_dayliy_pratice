package daliyTest2025.Mar.findDuplicate;

public class Solution {
    public int findDuplicate(int[] nums){
        int slow = 0,fast=0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
        slow = 0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {1,3,4,2,2};
        System.out.println(s.findDuplicate(nums));
    }
}

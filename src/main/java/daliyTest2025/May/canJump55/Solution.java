package daliyTest2025.May.canJump55;

import java.util.Arrays;

public class Solution {
    //直接贪心，维护能跳到最远的位置
    public boolean canJump(int[] nums){
        int n = nums.length;
        if(n==1)
            return true;
        int range = 0;
        for(int i=0;i<=range;i++){
            range = Math.max(range,nums[i]+i);
            if(range>=n-1)
                return true;
        }
        return false;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {3,2,1,0,4};
        System.out.println(s.canJump(nums));
    }
}

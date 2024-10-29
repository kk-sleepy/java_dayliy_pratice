package dayliy_test.oct;


import java.util.Arrays;
import java.util.Collections;

class Solution16 {
    public double minimumAverage(int[] nums) {
        double x = 200.0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length/2;i++){
            double t;
            t = (nums[i]+nums[nums.length-i-1])/2.0;
            x = Math.min(x, t);
        }
        return x;
    }
}
public class t1016 {
    public static void main(String[] args) {
        Solution16 sol = new Solution16();
        int[] nums = {7,8,3,4,15,13,4,1};
        System.out.println(sol.minimumAverage(nums));
    }
}

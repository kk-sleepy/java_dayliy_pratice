package daliyTest2025.May.longestCycle;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestCycle(int[] nums) {
        int ans = -1, n = nums.length;
        int cur = 1;
        int[] visTime = new int[n];
        for (int i = 0; i < n; i++) {
            int x = i;
            int startTime = cur;
            while(x!=-1 && visTime[x]==0){
                visTime[x] = cur++;
                x = nums[x];
            }
            if(x!=-1 && visTime[x]>=startTime){
                ans = Math.max(ans , cur - visTime[x]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCycle(new int[]{1,2,0,4,5,6,3,8,9,7}));
    }
}

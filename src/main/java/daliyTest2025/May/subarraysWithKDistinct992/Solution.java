package daliyTest2025.May.subarraysWithKDistinct992;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return count(nums,k) - count(nums,k+1);
    }
    private int count(int[] nums, int k){
        Map<Integer,Integer> cnt = new HashMap<>();
        int ans = 0,l = 0;
        for(int i = 0;i<nums.length;i++){
            cnt.merge(nums[i],1,Integer::sum);
            while (l<=i && cnt.size()>=k){
                int out = cnt.get(nums[l]);
                if(out == 1)
                    cnt.remove(nums[l]);
                else
                    cnt.put(nums[l],out-1);
                l += 1;
            }
            ans += l;
        }
        return ans;
    }
}

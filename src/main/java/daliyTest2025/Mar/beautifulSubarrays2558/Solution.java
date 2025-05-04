package daliyTest2025.Mar.beautifulSubarrays2558;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long beautifulSubarrays(int[] nums){
        long ans = 0;
        Map<Integer,Integer> cnt = new HashMap();
        int mask = 0;
        cnt.put(0,1);
        for(int x : nums){
            mask ^= x;
            ans += cnt.getOrDefault(mask,0);
            cnt.put(mask,cnt.getOrDefault(mask,0) + 1);
        }
        return ans;
    }
    public static void main(String[] arg){
        Solution s = new Solution();
        int[] array = {4,3,1,2,4};
        System.out.println(s.beautifulSubarrays(array));
    }
}

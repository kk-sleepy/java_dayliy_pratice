package daliyTest2025.May.continuousSubarrays2762;

import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {
    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        int l = 0;
        TreeMap<Integer, Integer> t = new TreeMap<>();
        for(int i = 0;i<nums.length;i++){
            t.merge(nums[i],1,Integer::sum);
            while (t.lastKey() - t.firstKey() > 2){
                int out = nums[l];
                int c = t.get(out);
                if (c == 1) {
                    t.remove(out);
                } else {
                    t.put(out, c - 1);
                }
                l += 1;
            }
            ans += i - l + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.continuousSubarrays(new int[1]);
    }
}

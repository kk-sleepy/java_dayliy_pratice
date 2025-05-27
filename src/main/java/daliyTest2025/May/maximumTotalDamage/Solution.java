package daliyTest2025.May.maximumTotalDamage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : power) {
            cnt.merge(x, 1, Integer::sum);
        }
        int n = cnt.size();
        int[] a = new int[n];
        int k = 0;
        for (int x : cnt.keySet()) {
            a[k++] = x;
        }
        Arrays.sort(a);
        long[] dp = new long[n+1];
        int j = 0;
        for(int i = 0;i<n;i++){
            int x = a[i];
            while(a[j]+2<x){
                j += 1;
            }
            dp[i+1] = Math.max(dp[i],dp[j]+ (long) x *cnt.get(x));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{5,1,4};
        System.out.println(s.maximumTotalDamage(nums));
    }
}

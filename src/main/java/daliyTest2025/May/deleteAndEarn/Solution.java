package daliyTest2025.May.deleteAndEarn;

import java.util.*;

class Solution {
    public int deleteAndEarn(int[] nums) {
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }

        int[] a = new int[mx + 1];
        for (int x : nums) {
            a[x] += x; // 统计等于 x 的元素之和
        }

        return rob(a);
    }

    // 198. 打家劫舍
    private int rob(int[] nums) {
        int f0 = 0;
        int f1 = 0;
        for (int x : nums) {
            int newF = Math.max(f1, f0 + x);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }
}

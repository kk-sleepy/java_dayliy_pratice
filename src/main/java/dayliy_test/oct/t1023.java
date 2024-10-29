package dayliy_test.oct;

import java.util.HashSet;

class Solution29 {
    public long countCompleteDayPairs(int[] hours) {
        int[] a = new int[24];
        long ans = 0;
        for (int i = 0; i < hours.length; i++) {
            int t = hours[i] % 24;
            hours[i] = t;
            a[t] += 1;
        }
        for (int i = 0; i < hours.length; i++) {
            int t, x;
            x = (24 - hours[i]) % 24;
            if (x != 12&&x != 0) {
                t = a[x];
            } else {
                t = a[x] - 1;
            }
            ans += t;
        }
        return ans / 2;
    }
}

public class t1023 {
    public static void main(String[] args) {
        Solution29 s = new Solution29();
        System.out.println(s.countCompleteDayPairs(new int[]{12,12,30,24,24}));
    }
}

package dayliy_test.sept;

import static java.lang.Math.min;

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum1=0,sum2=0;
        int x;
        int n = distance.length;
        int i = start;
        while (i != destination) {
            sum1 += distance[i];
            i = (i + 1) % n;
        }
        i = start;
        while (i != destination) {
            int t = (i - 1 + n) % n;
            sum2 += distance[t];
            i = t;
        }
        x = min(sum1,sum2);
        return x;
    }
}
public class t0916 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ds = {1,2,3,4};
        System.out.println(s.distanceBetweenBusStops(ds,0,1));
    }
}

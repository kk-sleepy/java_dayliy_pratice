package dayliy_test.sept;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
//    前缀和算法
    public int numberOfPoints(List<List<Integer>> nums) {
        int maxEnd = 0;
        for (List<Integer> p : nums) {
            maxEnd = Math.max(maxEnd, p.get(1));
        }

        int[] diff = new int[maxEnd + 2];
        for (List<Integer> interval : nums) {
            diff[interval.get(0)]++;
            diff[interval.get(1) + 1]--;
        }

        int ans = 0;
        int s = 0;
        for (int d : diff) {
            s += d;
            if (s > 0) {
                ans++;
            }
        }
        return ans;
    }
}

public class t20240915 {
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(3, 6));
        nums.add(Arrays.asList(1, 5));
        nums.add(Arrays.asList(4, 7));
        Solution solution = new Solution();
        System.out.println(solution.numberOfPoints(nums));
    }
}

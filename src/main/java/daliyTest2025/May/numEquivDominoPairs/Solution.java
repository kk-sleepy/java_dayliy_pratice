package daliyTest2025.May.numEquivDominoPairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int n = dominoes.length;
        int ans = 0;
        int[] cnt = new int[100];
        for (int i = 0; i < n; i++) {
            int x = dominoes[i][0];
            int y = dominoes[i][1];
            int val;
            if(x<=y){
                val = x*10 + y;
            }else{
                val = y * 10 + x;
            }
            ans += cnt[val];
            cnt[val] += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = new int[][]{{1,2},{1,2},{1,1},{1,2},{2,2}};
        System.out.println(s.numEquivDominoPairs(nums));
    }
}

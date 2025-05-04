package daliyTest2025.Mar.differenceOfDistinctValues;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] ans = new int[n][m];
        Set<Integer> st = new HashSet<>();
        for (int len = 1; len < n + m; len++) {
            int maxj = Math.min(m - 1, m + n - len - 1);
            int minj = Math.max(0, m - len);
            st.clear();
            for (int j = minj; j <= maxj; j++) {
                int i = len + j - m;
                ans[i][j] = st.size();
                st.add(grid[i][j]);
            }
            st.clear();
            for (int j = maxj; j >= minj; j--) {
                int i = len + j - m;
                ans[i][j] = Math.abs(ans[i][j] - st.size());
                st.add(grid[i][j]);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[][] grid = {{1,2,3},{3,1,5},{3,2,1}};
        int[][] ans = s.differenceOfDistinctValues(grid);
        for(int[] row:ans){
            for(int col:row){
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}

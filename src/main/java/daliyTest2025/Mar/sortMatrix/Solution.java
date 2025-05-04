package daliyTest2025.Mar.sortMatrix;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] ans = new int[n][m];
        for (int k = 1; k <= m + n - 1; k++) {
            int minj = Math.max(0, m - k);
            int maxj = Math.min(m + n - 1 - k, m - 1);
            if (k <= (m + n - 1) / 2) {
                PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                });
                for (int j = minj; j <= maxj; j++) {
                    int i = j + k - m;
                    queue.offer(grid[i][j]);
                }
                for (int j = minj; j <= maxj; j++) {
                    int i = j + k - m;
                    ans[i][j] = queue.poll();
                }
            } else {
                PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return b - a;
                    }
                });
                for (int j = minj; j <= maxj; j++) {
                    int i = j + k - m;
                    queue.offer(grid[i][j]);
                }
                for (int j = minj; j <= maxj; j++) {
                    int i = j + k - m;
                    ans[i][j] = queue.poll();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{1, 7, 3}, {9, 8, 2}, {4, 5, 6}};
        int[][] ans = s.sortMatrix(grid);
        for (int[] row : ans) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}

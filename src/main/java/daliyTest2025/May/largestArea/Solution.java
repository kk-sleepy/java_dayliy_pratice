package daliyTest2025.May.largestArea;

class Solution {
    int m;
    int n;
    int area = 1;
    boolean isSpace;
    int[][] dirts = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int largestArea(String[] grid) {
        m = grid.length;
        n = grid[0].length();
        int maxArea = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!visited[i][j] && grid[i].charAt(j) != '0') {
                    area = 1;
                    isSpace = true;
                    visited[i][j] = true;
                    dfs(grid, i, j, visited, grid[i].charAt(j));
                    if (isSpace) {
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
        }
        return maxArea;
    }

    public void dfs(String[] grid, int row, int col, boolean[][] visited, char activity) {
        for (int[] dirt : dirts) {
            int nextRow = row + dirt[0];
            int nextCol = col + dirt[1];
            if (visited[nextRow][nextCol]) {
                continue;
            }
            if (grid[nextRow].charAt(nextCol) == '0'
                    || ((grid[nextRow].charAt(nextCol) == activity)
                    && (nextRow == 0 || nextRow == m - 1 || nextCol == 0 || nextCol == n - 1))) {
                isSpace = false;
            } else if (grid[nextRow].charAt(nextCol) == activity) {
                area++;
                visited[nextRow][nextCol] = true;
                dfs(grid, nextRow, nextCol, visited, activity);
            }
        }
    }
}
package daliyTest2025.May.nearestExit;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length, m = maze[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(entrance);
        maze[entrance[0]][entrance[1]] = '+'; // 标记入口为已访问
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int[] dir : directions) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];
                    if (x >= 0 && x < n && y >= 0 && y < m && maze[x][y] == '.') {
                        if (x == 0 || x == n - 1 || y == 0 || y == m - 1) {
                            return steps + 1; // 找到出口
                        }
                        maze[x][y] = '+'; // 标记为已访问
                        queue.add(new int[]{x, y});
                    }
                }
            }
            steps++;
        }
        return -1; // 无法找到出口
    }

    public static void main(String[] args) {
        char[][] map = new char[][]{{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}};
        Solution s = new Solution();
        System.out.println(s.nearestExit(map, new int[]{1, 0}));
    }
}
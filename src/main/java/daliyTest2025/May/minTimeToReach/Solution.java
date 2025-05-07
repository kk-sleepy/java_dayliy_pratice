package daliyTest2025.May.minTimeToReach;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    private final static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        int[][] dis = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        pq.offer(new int[]{0, 0, 0});
        for (int[] d : dis) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        while (!pq.isEmpty()) {
            int[] head = pq.poll();
            int x = head[1], y = head[2], d = head[0];
            if (x == n - 1 && y == m - 1)
                return d;
            if (d > dis[x][y])
                continue;
            int time = (x + y) % 2 + 1;
            for (int[] q : DIRS) {
                int i = x + q[0], j = y + q[1];
                if (i >= 0 && i < n && j >= 0 && j < m) {
                    int newDis = Math.max(d, moveTime[i][j]) + time;
                    if (newDis < dis[i][j]) {
                        dis[i][j] = newDis;
                        pq.offer(new int[]{newDis, i, j});
                    }
                }
            }
        }
        return dis[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] moveTime = new int[][]{{0, 4}, {4, 4}};
        System.out.println(s.minTimeToReach(moveTime));
    }
}

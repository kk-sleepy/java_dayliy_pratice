package daliyTest2025.May.shortestPathBinaryMatrix;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ans = 0;
        int n = grid.length,m = grid[0].length;
        int[][] dict = new int[][]{{1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1}};
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1)
            return -1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                int[] q = queue.poll();
                if(q[0] == n-1 && q[1] == m -1)
                    return ans + 1;
                for(int[] d: dict){
                    int x = q[0] + d[0];
                    int y = q[1] + d[1];
                    if(x>=0 && x<n && y>=0&&y<m){
                        if(grid[x][y] == 0){
                            grid[x][y] = 1;
                            queue.add(new int[]{x,y});
                        }
                    }
                }
            }
            ans += 1;
        }
        return -1;
    }
    /**
     * -0 -1   -1 -1
     * -1  0  -0  0
     * -1  -1  -1  0
     * -1  -1  -1  -1
     */
}

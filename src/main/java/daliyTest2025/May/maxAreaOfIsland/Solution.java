package daliyTest2025.May.maxAreaOfIsland;

class Solution {
    int temp;
    int n;
    int m;
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        n = grid.length;
        m = grid[0].length;
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0){
                    continue;
                }
                temp = 0;
                dfs(i,j,grid);
                ans = Math.max(temp,ans);
            }
        }
        return ans;
    }
    void dfs(int x,int y,int[][] grid){
        if(x<0 || x >= n || y<0 || y >= m)
            return;
        if(grid[x][y] == 0)
            return;
        temp += 1;
        grid[x][y] = 0;
        dfs(x+1,y,grid);
        dfs(x-1,y,grid);
        dfs(x,y+1,grid);
        dfs(x,y-1,grid);
    }

    public static void main(String[] args) {

    }
}

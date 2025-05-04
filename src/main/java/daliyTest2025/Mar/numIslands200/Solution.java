package daliyTest2025.Mar.numIslands200;

public class Solution {
    public int numIslands(char[][] grid){
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    ans += 1;
                    dfs(grid,i,j);
                }
            }
        }

        return ans;
    }
    private void dfs(char[][] grid, int i, int j){
        int n = grid.length, m = grid[0].length;
        if(i<0||j<0||i>=n||j>=m||grid[i][j]=='0')
            return;
        grid[i][j] = '0';
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
    }
    public static void main(String[] args){
        Solution s = new Solution();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(s.numIslands(grid));
    }
}

package daliyTest2025.May.pondSizes;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> ans;
    int n;
    int m;
    int temp;
    public int[] pondSizes(int[][] land) {
        ans = new ArrayList<>();
        n = land.length;
        m = land[0].length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(land[i][j] == 0){
                    temp = 0;
                    dfs(i,j,land);
                    ans.add(temp);
                }
            }
        }
        ans.sort((a,b)->a-b);
        int len = ans.size();
        int[] res = new int[len];
        int i = 0;
        for(int x : ans){
            res[i++] = x;
        }
        return res;
    }
    void dfs(int x,int y,int[][] land){
        if(x<0 || x >= n || y<0 || y >= m)
            return;
        if(land[x][y] != 0)
            return;
        temp += 1;
        land[x][y] = 1;
        dfs(x+1,y,land);
        dfs(x-1,y,land);
        dfs(x,y+1,land);
        dfs(x,y-1,land);
        dfs(x+1,y+1,land);
        dfs(x-1,y-1,land);
        dfs(x-1,y+1,land);
        dfs(x+1,y-1,land);
    }
}
package daliyTest2025.May.findCircleNum;

class Solution {
    private int n;
    private int m;
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        n = isConnected.length;
        m = isConnected[0].length;
        for(int i = 0;i<n;i++){
            int x = 0;
            for(int j = 0;j<m;j++){
                if(isConnected[i][j] == 1){
                    x = 1;
                    isConnected[i][j] = 0;
                    if(i == j)
                        continue;
                    dfs(j,j,isConnected);
                }
            }
            ans += x;
        }
        return ans;
    }
    void dfs(int i,int j,int[][] isConnected){
        if(i<0 || j < 0 || i >= n || j >= m)
            return;
        if(isConnected[i][j] == 0)
            return;
        isConnected[i][j] = 0;
        for(int k = 0;k<m;k++){
            if(isConnected[j][k] == 1){
                isConnected[j][k] = 0;
                dfs(k,k,isConnected);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(s.findCircleNum(nums));
    }
}

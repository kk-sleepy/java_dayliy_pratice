package daliyTest2025.May.allPathsSourceTarget;

import java.util.*;
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        dfs(0,graph,new ArrayList<Integer>());
        return ans;
    }
    void dfs(int i,int[][] graph,List<Integer> temp){
        temp.add(i);
        if(i == graph.length - 1){
            ans.add(new ArrayList<>(temp));
        }
        for(int x : graph[i]){
            dfs(x,graph,temp);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}});
    }
}

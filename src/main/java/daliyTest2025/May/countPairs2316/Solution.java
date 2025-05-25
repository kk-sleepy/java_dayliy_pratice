package daliyTest2025.May.countPairs2316;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public long countPairs(int n, int[][] edges) {
        long ans = 0;
        List<Integer> cnt = new ArrayList<>();
        boolean[] vis = new boolean[n];
        List<Integer>[] adj = new List[n];
        for(int i = 0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        for(int i = 0;i<n;i++){
            if(vis[i])
                continue;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            vis[i] = true;
            int temp = 1;
            while(!queue.isEmpty()){
                int x = queue.poll();
                for(Integer y : adj[x]){
                    if(!vis[y]){
                        temp += 1;
                        vis[y] = true;
                        queue.offer(y);
                    }
                }
            }
            cnt.add(temp);
        }
        int m = cnt.size();
        long[] sub = new long[m+1];
        for(int i = m - 1;i>0;i--){
            sub[i] = sub[i+1] + cnt.get(i);
        }
        for(int i = 0;i<m-1;i++){
            ans += cnt.get(i) * sub[i+1];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = new int[][]{{0,2},{0,5},{2,4},{1,6},{5,4}};
        System.out.println(s.countPairs(7,nums));
    }
}

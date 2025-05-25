package daliyTest2025.May.validPath1971;

import java.util.*;
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new List[n];
        for(int i = 0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] data : edges){
            adj[data[0]].add(data[1]);
            adj[data[1]].add(data[0]);
        }
        boolean[] vis = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        vis[source] = true;
        while(!queue.isEmpty()){
            int x = queue.poll();
            for(Integer j : adj[x]){
                if(!vis[j]) {
                    vis[j] = true;
                    queue.offer(j);
                }
            }
        }
        return vis[destination];
    }
}
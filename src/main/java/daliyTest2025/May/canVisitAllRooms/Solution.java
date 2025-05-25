package daliyTest2025.May.canVisitAllRooms;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

class Solution {
    boolean[] vis;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        vis = new boolean[n];
        vis[0] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        vis[0] = true;
        while(!queue.isEmpty()){
            int x = queue.poll();
            for(Integer y : rooms.get(x)){
                if(!vis[y]){
                    vis[y] = true;
                    queue.offer(y);
                }
            }
        }
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                return false;
            }
        }
        return true;
    }
}
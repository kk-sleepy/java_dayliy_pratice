package daliyTest2025.May.validPath1971;

import java.util.*;
class Solution {
    int[]parents;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parents = new int[n];
        for(int i=0;i<n;i++){
            parents[i] = i;
        }
        for(int[] edge : edges){
            merge(edge[0],edge[1]);
        }
        return find(source) == find(destination);
    }
    int find(int x){
        if(x != parents[x]){
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }
    void merge(int x,int y){
        parents[find(x)] = find(y);
    }
}
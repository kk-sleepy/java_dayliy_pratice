package daliyTest2025.May.canFinish;
import java.util.*;
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        List<Integer>[] g = new ArrayList[numCourses];
        Arrays.setAll(g, i-> new ArrayList<>());
        for(int[] data : prerequisites){
            g[data[1]].add(data[0]);
        }
        int[] idx = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(idx[i] == 0 && dfs(i,idx,g))
                return false;
        }
        return true;
    }
    //[1,0]
    private boolean dfs(int i,int[] idx,List<Integer>[] g){
        idx[i] = 1;
        for(int x : g[i]){
            if(idx[x]==1 || idx[x] == 0 && dfs(x,idx,g) ){
                return true;
            }
        }
        idx[i] = 2;
        return false;
    }

    public static void main(String[] args) {

    }
}

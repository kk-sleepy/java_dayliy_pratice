package daliyTest2025.May.generateParenthesis;

import java.util.*;
public class Solution {
    private List<String> ans;
    private int n;
    public List<String> generateParenthesis(int n) {
        this.n = n*2;
        ans = new ArrayList<>();
        dfs(0,"",0);
        return ans;
    }
    private void dfs(int i,String path,int sum){
        if(i == n){
            if(sum == 0)
                ans.add(path);
            return;
        }
        if(sum < 0 ||n - i < sum)
            return;
        dfs(i+1,path+"(",sum+1);
        dfs(i+1,path+")",sum-1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for(String str : s.generateParenthesis(3))
            System.out.println(str);
    }
}

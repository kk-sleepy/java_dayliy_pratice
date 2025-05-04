package daliyTest2025.Mar.mostPoints;

public class Solution {
    public long mostPoints(int[][] questions){
        int n = questions.length;
        long[] memo = new long[n];
        long ans = dfs(questions,0,memo);
        return ans;
    }
    public long dfs(int[][] questions,int i,long[] memo){
        if(i>=memo.length){
            return 0;
        }
        if(memo[i]>0){
            return memo[i];
        }
        long notChoice = dfs(questions,i+1,memo);
        long choice = questions[i][0] + dfs(questions,i+questions[i][1]+1,memo);
        return memo[i] = Math.max(notChoice,choice);
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[][] nums = {{3,2},{4,3},{4,4},{2,5}};
        System.out.println(s.mostPoints(nums));
    }
}

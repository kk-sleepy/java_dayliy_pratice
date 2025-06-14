package daliyTest2025.Mar.longestValidParentheses;

class Solution {
    public int longestValidParentheses(String s){
        int ans = 0, n = s.length();
        int[] dp = new int[n];
        if(n<1)
            return 0;
        for(int i=1;i<n;i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i] = (i>=2?dp[i-2]:0) + 2;
                }else{
                    if(i-dp[i-1]>0&&s.charAt(i-dp[i-1]-1)=='('){
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                }
                ans = Math.max(ans,dp[i]);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses("(()"));
    }
}

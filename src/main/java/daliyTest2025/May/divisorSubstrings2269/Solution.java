package daliyTest2025.May.divisorSubstrings2269;

public class Solution {
    public int divisorSubstrings(int num, int k){
        String s = "" + num;
        int ans = 0, n = s.length();
        for(int i=0;i<n-k+1;i++){
            int t = Integer.parseInt(s.substring(i,i+k));
            if(t!=0&&num%t==0){
                ans += 1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.divisorSubstrings(430043,2));
    }
}

package daliyTest2025.May.equalSubstring1208;

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] ss = s.toCharArray(),tt = t.toCharArray();
        int n = ss.length;
        int ans = 0;
        int temp = 0;
        int l = 0;
        for(int i=0;i<n;i++){
            temp += Math.abs(tt[i] - ss[i]);
            while(temp > maxCost){
                temp -= Math.abs(tt[l] - ss[l]);
                l += 1;
            }
            ans = Math.max(ans,i - l + 1);
        }
        return ans;
    }
}

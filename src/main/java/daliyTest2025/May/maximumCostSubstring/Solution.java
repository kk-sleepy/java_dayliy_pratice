package daliyTest2025.May.maximumCostSubstring;

class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int ans = 0;
        int[] cnt = new int[26];
        char[] ctr = chars.toCharArray();
        boolean[] vis = new boolean[26];
        for (int i = 0; i < ctr.length; i++) {
            cnt[ctr[i] - 'a'] = vals[i];
            vis[ctr[i] - 'a'] = true;
        }
        char[] snum = s.toCharArray();
        int n = snum.length;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            int x = snum[i] - 'a';
            int y = 0;
            if (vis[x]) {
                y = Math.max(0, pre) + cnt[x];
            } else {
                y = Math.max(0,pre) + x + 1;
            }
            pre = y;
            ans = Math.max(ans,y);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maximumCostSubstring("adaa","d",new int[]{-1000}));
    }
}
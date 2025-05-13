package daliyTest2025.May.lengthAfterTransformations;

class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int ans = 0;
        int[] cnt = new int[26];
        int  mod = 1_000_000_000 + 7;
        for(char c : s.toCharArray()){
            cnt[c-'a'] += 1;
        }
        for(int i=0;i<t;i++){
            int[] nxt = new int[26];
            nxt[0] = cnt[25];
            nxt[1] = (cnt[25] + cnt[0]) % mod;
            for(int j = 2;j<26;j++){
                nxt[j] = cnt[j-1];
            }
            cnt = nxt;
        }
        for(int i=0;i<26;i++){
            ans = (ans + cnt[i]) % mod;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "abcyy";
        System.out.println(s.lengthAfterTransformations(str,2));
    }
}
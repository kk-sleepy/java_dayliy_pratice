package daliyTest2025.May.numberOfSubstrings3225;

class Solution {
    public int numberOfSubstrings(String s, int k) {
        int ans = 0,l=0;
        int[] cnt = new int[26];
        char[] chars = s.toCharArray();
        int n = chars.length;
        for(int i = 0;i<n;i++){
            int x = chars[i] - 'a';
            cnt[x] += 1;
            while(cnt[x]>=k){
                cnt[chars[l]-'a'] -= 1;
                l += 1;
            }
            ans += l;
        }
        return ans;
    }
}

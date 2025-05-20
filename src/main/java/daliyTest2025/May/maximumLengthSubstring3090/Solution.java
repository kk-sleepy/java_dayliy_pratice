package daliyTest2025.May.maximumLengthSubstring3090;

class Solution {
    public int maximumLengthSubstring(String s) {
        int[] cnt = new int[26];
        int ans = 0;
        char[] str = s.toCharArray();
        int l = 0;
        for(int i = 0;i<str.length;i++){
            int x = str[i] - 'a';
            cnt[x] += 1;
            while(cnt[x] > 2){
                cnt[str[l] - 'a'] -= 1;
                l += 1;
            }
            ans = Math.max(ans,i - l + 1);
        }
        return ans;
    }
}
package daliyTest2025.May.countKConstraintSubstrings3258;

class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        char[] str = s.toCharArray();
        int n = str.length;
        int ans = 0,l = 0;
        int[] cnt = new int[2];
        for(int i = 0; i<n;i++){
            cnt[str[i]-'0'] += 1;
            while(cnt[0] > k && cnt[1] > k){
                cnt[str[l]-'0'] -= 1;
                l += 1;
            }
            ans += i - l + 1;
        }
        return ans;
    }
}

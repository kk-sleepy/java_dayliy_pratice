package daliyTest2025.May.validSubstringCount3298;

class Solution {
    public long validSubstringCount(String word1, String word2) {
        long ans = 0;
        int l = 0;
        int[] cnt1 = new int[26], cnt2 = new int[26];
        for(char c : word2.toCharArray()){
            cnt2[c-'a'] += 1;
        }
        char[] str1 = word1.toCharArray();
        int n = str1.length;
        for(int i = 0;i<n;i++){
            cnt1[str1[i] - 'a'] += 1;
            while(check(cnt1,cnt2)){
                cnt1[str1[l]-'a'] -= 1;
                l += 1;
            }
            ans += l;
        }
        return ans;
    }
    private boolean check(int[] cnt1,int[] cnt2){
        for(int i = 0;i<26;i++){
            if(cnt1[i]<cnt2[i])
                return false;
        }
        return true;
    }
}

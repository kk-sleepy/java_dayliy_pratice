package daliyTest2025.May.numberOfSubstrings1358;

class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        char[] str = s.toCharArray();
        int n = str.length;
        int[] cnt = new int[3];
        int l = 0;
        for(int i = 0;i<n;i++){
            cnt[str[i]-'a'] += 1;
            while(cnt[0]>0 && cnt[1]>0 && cnt[2]>0){
                cnt[str[l]-'a'] -= 1;
                l += 1;
            }
            ans += l;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numberOfSubstrings("abcabc"));
    }
}

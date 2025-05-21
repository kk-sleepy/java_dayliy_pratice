package daliyTest2025.May.balancedString1234;

class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int m = n / 4;
        int ans = n+1,l=0;
        char[] str = s.toCharArray();
        int[] cnt = new int[4];
        for(int i=0;i<n;i++){
            cnt[get(str[i])] += 1;
        }
        if(cnt[0]==cnt[1] && cnt[2] == cnt[3] && cnt[0]==cnt[2])
            return 0;
        for(int i=0;i<n;i++){
            cnt[get(str[i])] -= 1;
            while(cnt[0]<=m && cnt[1]<=m&&cnt[2]<=m&&cnt[3]<=m){
                cnt[get(str[l])] += 1;
                ans = Math.min(ans,i-l+1);
                l += 1;
            }
        }
        return ans;
    }
    //{QQWWER}
    private int get(char c){
        return switch (c) {
            case 'Q' -> 0;
            case 'W' -> 1;
            case 'E' -> 2;
            default -> 3;
        };
    }
}

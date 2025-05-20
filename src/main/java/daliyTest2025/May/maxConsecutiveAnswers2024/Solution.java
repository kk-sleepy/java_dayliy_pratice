package daliyTest2025.May.maxConsecutiveAnswers2024;

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] answer = answerKey.toCharArray();
        int n = answer.length;
        if(k == n)
            return n;
        int ans = 0,l = 0;
        int[] cnt = new int[2];
        for(int i = 0;i<n;i++){
            cnt[get(answer[i])] += 1;
            while(cnt[0] > k && cnt[1] > k){
                cnt[get(answer[l])] -= 1;
                l += 1;
            }
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
    private int get(char c){
        if(c == 'T')
            return 0;
        else
            return 1;
    }
}

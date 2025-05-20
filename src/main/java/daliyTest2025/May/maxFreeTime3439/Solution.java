package daliyTest2025.May.maxFreeTime3439;

class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int ans = 0;
        int n = startTime.length;
        int[] cnt = new int[n+1];
        for(int i = 0;i<n;i++){
            if(i == 0)
                cnt[i] = startTime[i];
            else
                cnt[i] = startTime[i] - endTime[i-1];
        }
        cnt[n] = eventTime - endTime[n-1];
        int temp = 0;
        for(int i = 0;i<=n;i++){
            temp += cnt[i];
            if(i < k){
                continue;
            }
            ans = Math.max(temp,ans);
            temp -= cnt[i-k];
        }
        ans = Math.max(temp,ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxFreeTime(21,1,new int[]{7,10,16},new int[]{10,14,18,}));;
    }
}

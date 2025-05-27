package daliyTest2025.May.kConcatenationMaxSum;

class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int mod = 1_000_000_000 + 7;
        int sum = 0;
        long ans = 0;
        int n = arr.length;
        if(k == 1){
            int pre = 0;
            for(int i = 0;i<n;i++){
                pre = Math.max(0,pre) + arr[i%n];
                ans = Math.max(ans,pre);
            }
            return (int) ans;
        }
        for(int x : arr){
            sum = (x + sum) % mod;
        }
        int pre = 0;
        for(int i = 0;i<2*n;i++){
            pre = Math.max(0,pre) + arr[i%n];
            ans = Math.max(ans,pre);
        }
        if(sum > 0){
            ans += (long) (k - 2) *sum;
        }
        return (int) (ans % mod);
    }
}

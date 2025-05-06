package daliyTest2025.May.numTilings;

public class Solution {
    public int numTilings(int n) {
        int mod = 1_000_000_007;
        int f0 = 1, f1 = 1, f2 = 2;
        if(n==1){
            return f0;
        }
        for(int i = 3;i<=n;i++){
            long f3 = (2 * f2 + f0) % mod;
            f0 = f1;
            f1 = f2;
            f2 = (int)f3;
        }
        return (int) f2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}

package daliyTest2025.Mar.sumOfBeauties2012;

public class Solution {
    public int sumOfBeauties(int[] sums){
        int n = sums.length;
        int ans = 0;
        int[] idx = new int[n];
        idx[n-1] = sums[n-1];
        for(int i=n-2;i>0;i--){
            idx[i] = Math.min(idx[i+1],sums[i]);
        }
        int maxx = sums[0];
        for(int i=1;i<n-1;i++){
            if(sums[i]>maxx&&sums[i]<idx[i+1]){
                ans += 2;
            }else if(sums[i]>sums[i-1]&&sums[i]<sums[i+1]){
                ans += 1;
            }
            maxx = Math.max(maxx,sums[i]);
        }
        return ans;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] data = {1,2,3,4};
        System.out.println(s.sumOfBeauties(data));
    }
}

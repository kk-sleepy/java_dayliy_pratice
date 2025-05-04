package daliyTest2025.Mar.minimumSum;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minimumSum(int n, int k){
        int ans = 0;
        Set<Integer> cnt = new HashSet<>();
        int i = 1,res = 0;
        while(res<n){
            if(i<k&&!cnt.contains(i)){
                ans += i;
                cnt.add(k-i);
                res += 1;
            }
            if(i>=k){
                ans += i;
                res += 1;
            }
            i += 1;
        }
        return ans;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.minimumSum(5,4));
    }
}

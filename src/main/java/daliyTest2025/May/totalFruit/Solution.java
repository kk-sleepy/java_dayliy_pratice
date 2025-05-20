package daliyTest2025.May.totalFruit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int totalFruit(int[] fruits) {
        int ans = 0;
        int n = fruits.length;
        Map<Integer,Integer> cnt = new HashMap<>();
        int l = 0;
        for(int i=0;i<n;i++){
            cnt.merge(fruits[i],1,Integer::sum);
            while(cnt.size()>2){
                cnt.merge(fruits[l],-1,Integer::sum);
                if(cnt.get(fruits[l]) == 0){
                    cnt.remove(fruits[l]);
                }
                l += 1;
            }
            ans = Math.max(i - l + 1,ans);
        }
        return ans;
    }
}

package daliyTest2025.May.beautifulBouquet68;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int beautifulBouquet(int[] flowers, int cnt) {
        int mod = 1000000007;
        int n = flowers.length;
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0, l = 0;
        for(int i = 0;i<n;i++){
            map.merge(flowers[i],1,Integer::sum);
            while(map.get(flowers[i])>cnt){
                int out = map.get(flowers[l]);
                if(out == 1){
                    map.remove(flowers[l]);
                }else{
                    map.put(flowers[l],out - 1);
                }
                l += 1;
            }
            ans = (ans + i - l + 1) % mod;
        }
        return ans;
    }
}
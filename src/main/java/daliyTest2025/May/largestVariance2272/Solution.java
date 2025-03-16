package daliyTest2025.May.largestVariance2272;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int largestVariance(String s){
        int ans = 0;
        int n = s.length();
        for(char a='a';a<='z';a++){
            for(char b='a';b<='z';b++){
                if(a==b)
                    continue;
                int f0=0, f1=Integer.MIN_VALUE;
                for(int i=0;i<n;i++){
                    char c = s.charAt(i);
                    if(c==a){
                        f1 += 1;
                        f0 = Math.max(f0,0) + 1;
                    }else if(c==b){
                        f1 = f0 = Math.max(f0,0) - 1;
                    }
                    ans = Math.max(f1,ans);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.largestVariance("aababbb"));
    }
}

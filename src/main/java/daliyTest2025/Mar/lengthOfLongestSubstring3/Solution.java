package daliyTest2025.Mar.lengthOfLongestSubstring3;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s){
        Set<Character> cnt = new HashSet();
        int ans = 0;
        int n = s.length();
        int l = 0;
        for(int r=0;r<n;r++){
            char ch = s.charAt(r);
            if(!cnt.contains(ch)){
                cnt.add(ch);
            }else{
                ans = Math.max(ans,r-l);
                while(true){
                    char lch = s.charAt(l);
                    l += 1;
                    if(lch==ch){
                        break;
                    }
                    cnt.remove(lch);
                }
            }
        }
        ans = Math.max(ans,cnt.size());
        return ans;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring(" "));
    }
}

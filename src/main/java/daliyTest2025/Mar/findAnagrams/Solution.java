package daliyTest2025.Mar.findAnagrams;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p){
        List<Integer> ans = new ArrayList<>();
        int slen = s.length(), plen = p.length();
        int[] ss = new int[26];
        int[] pp = new int[26];
        for(int i=0;i<plen;i++){
            int c = p.charAt(i)-'a';
            pp[c] += 1;
            ss[s.charAt(i)-'a'] += 1;
        }
        for(int i =plen;i<slen;i++){
            if(check(ss,pp))
                ans.add(i-plen);
            ss[s.charAt(i-plen)-'a'] -= 1;
            ss[s.charAt(i)-'a'] += 1;
        }
        if(check(ss,pp))
            ans.add(slen-plen);
        return ans;
    }
    private boolean check(int[] s, int[] p){
        for(int i=0;i<26;i++){
            if(s[i]!=p[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> ans = s.findAnagrams("abab","ab");
        for(Integer data : ans){
            System.out.println(data);
        }
    }
}

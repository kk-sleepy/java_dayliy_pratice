package daliyTest2025.May.countOfSubstrings3305;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    private int count(String word, int k) {
        int ans = 0;
        HashMap<Character, Integer> cnt1 = new HashMap<>();
        int cnt2 = 0;
        int left = 0;
        char[] words = word.toCharArray();
        for(char r:words){
            if("aoeiu".indexOf(r)>=0){
                cnt1.put(r,cnt1.getOrDefault(r,0)+1);
            }else{
                cnt2 += 1;
            }
            while(cnt1.size()==5 && cnt2>=k){
                char t = words[left];
                if("aoeiu".indexOf(t)>=0){
                    cnt1.put(t,cnt1.getOrDefault(t,0)-1);
                    if(cnt1.getOrDefault(t,0)==0)
                        cnt1.remove(t);
                }else{
                    cnt2 -= 1;
                }
                left += 1;
            }
            ans += left;
        }
        return ans;
    }
    public int countOfSubstrings(String word, int k) {
        return count(word, k) - count(word, k + 1);
    }
    public static void main(String[] args){
        Solution s = new Solution();
        String word = "aeiou";
        int k = 1;
        System.out.println(s.countOfSubstrings(word,k));
    }
}

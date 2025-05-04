package daliyTest2025.May.minWindow;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> cnt = new HashMap<>();
        Map<Character, Integer> cnt2 = new HashMap<>();
        int min = s.length();
        String ans = "";
        if(s.length()<t.length()){
            return "";
        }
        for (char c : t.toCharArray()) {
            cnt.merge(c, 1, Integer::sum);
        }
        int i = 0;
        for(int j = 0;j<s.length();j++){
            char c = s.charAt(j);
            cnt2.merge(c,1,Integer::sum);
            while(check(cnt,cnt2)){
                if((j - i + 1) <= min){
                    min = j - i + 1;
                    ans = s.substring(i,j+1);
                }
                cnt2.merge(s.charAt(i),-1,Integer::sum);
                i += 1;
            }
        }
        return ans;
    }
    private boolean check(Map<Character, Integer> cnt1,Map<Character, Integer> cnt2){
        for(Character x : cnt1.keySet()){
            if( !cnt2.containsKey(x) || cnt1.get(x) > cnt2.get(x))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
    }
}

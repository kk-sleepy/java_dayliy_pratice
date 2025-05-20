package daliyTest2025.May.maxVowels1456;

import java.util.HashSet;
import java.util.Set;

class Solution {
    private Set<Character> set = new HashSet<>();
    public int maxVowels(String s, int k) {
        int l = 0;
        int ans = 0;
        int temp = 0;
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for (int r = 0; r < s.length(); r++) {
            if(set.contains(s.charAt(r))){
                temp += 1;
            }
            if(r - l + 1 < k)
                continue;
            ans = Math.max(ans,temp);
            if(set.contains(s.charAt(l))){
                temp -= 1;
            }
            l += 1;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

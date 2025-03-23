package daliyTest2025.May.canBeValid2116;

import java.util.Stack;

public class Solution {
    public boolean canBeValid(String s, String locked) {
        int mx = 0, my = 0;
        char[] lock = locked.toCharArray();
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (lock[i] == '1') {
                if (c == '(') {
                    mx += 1;
                    my += 1;
                } else {
                    mx -= 1;
                    my -= 1;
                    if (my < 0)
                        return false;
                }
            } else {
                mx -= 1;
                my += 1;
            }
            if (mx < 0)
                mx = 1;
        }
        if (mx == 0)
            return true;
        else
            return false;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.canBeValid("((()(()()))()((()()))))()((()(()","10111100100101001110100010001001"));
    }
}

package daliyTest2025.May.decodeString;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        List<Integer> multi = new LinkedList<>();
        List<String> pre = new LinkedList<>();
        int multis = 0;
        for(Character c : s.toCharArray()){
            if(c >= '0' && c<='9'){
                multis = multis * 10 + (c - '0');
            }else if(c == '['){
                pre.addLast(ans.toString());
                ans = new StringBuilder();
                multi.addLast(multis);
                multis = 0;
            }else if(c == ']'){
                int multiTemp = multi.removeLast();
                StringBuilder temp = new StringBuilder();
                for(int i = 0;i<multiTemp;i++){
                    temp.append(ans);
                }
                ans = new StringBuilder(pre.removeLast() + temp);
            }else{
                ans.append(c);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.decodeString("3[a]2[bc]"));
    }
}

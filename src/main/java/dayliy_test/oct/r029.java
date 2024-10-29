package dayliy_test.oct;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<String>();
    int n;

    public List<String> validStrings(int n) {
        this.n = n;
        dfs(new StringBuilder());
        return res;
    }

    public void dfs(StringBuilder sb) {
        if (sb.length() == n) {
            res.add(sb.toString());
        } else {
            if (sb.isEmpty() || sb.charAt(sb.length() - 1) == '1') {
                sb.append('0');
                dfs(sb);
                sb.setLength(sb.length() - 1);
            }
            sb.append('1');
            dfs(sb);
            sb.setLength(sb.length() - 1);
        }
    }
}


public class r029 {
    public static void main(String[] args) {
        int n = 3;
        Solution solution = new Solution();
        List<String> ans = solution.validStrings(n);
        for(String s : ans){
            System.out.println(s + " ");
        }
    }
}

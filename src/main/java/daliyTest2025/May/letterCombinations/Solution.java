package daliyTest2025.May.letterCombinations;
import java.util.*;
class Solution {
    private List<String> ans;
    private String[] data;
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
            return null;
         ans = new ArrayList<>();
        data = new String[8];
        data[0] = "abc"; data[1] = "def"; data[2] = "ghi";data[3] = "jkl";
        data[4] = "mno"; data[5] = "pqrs"; data[6] = "tuv"; data[7] = "wxyz";
        dfs(digits,0,"");
        return ans;
    }
    public void dfs(String digits,int i,String str){
        if(i == digits.length()){
            ans.add(str);
            return;
        }
        int x = digits.charAt(i) - '2';
        for(char c : data[x].toCharArray()){
            dfs(digits,i + 1,str + c);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> ans = s.letterCombinations("23");
        for(String str : ans)
            System.out.println(str);
    }
}

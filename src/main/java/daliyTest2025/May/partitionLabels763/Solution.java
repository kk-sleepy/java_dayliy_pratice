package daliyTest2025.May.partitionLabels763;
import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        char[] str = s.toCharArray();
        int n = s.length();
        int[] last = new int[n];
        for(int i = 0;i<n;i++){
            last[str[i] - 'a'] = i;
        }
        int start = 0, end = 0;
        for(int i=0;i<n;i++){
            end = Math.max(last[str[i]-'a'],end);
            if(end == i){
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.partitionLabels("ababcbacadefegdehijhklij");
    }
}

package daliyTest2025.Mar.groupAnagrams49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> ans;
        Map<String,List<String>> m = new HashMap<>();
        for(String str : strs){
            char[] tch = str.toCharArray();
            Arrays.sort(tch);
            m.computeIfAbsent(new String(tch),k->new ArrayList<>()).add(str);
        }
        return new ArrayList<>(m.values());
    }
    public static void main(String[] args){
        Solution s = new Solution();
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ans = s.groupAnagrams(str);
        for(List<String> lstr:ans){
            for(String sstr:lstr){
                System.out.print(sstr + " ");
            }
            System.out.println();
        }
    }
}

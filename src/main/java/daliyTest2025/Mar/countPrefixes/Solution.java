package daliyTest2025.Mar.countPrefixes;

import java.util.Arrays;

class Solution {
    public int countPrefixes(String[] words,String s){
        int ans = 0;
        for(String word : words){
            if(s.startsWith(word)){
                ans += 1 ;
            }
        }
        return ans;
    }

    public int countPrefixesStream(String[] words,String s){
        return (int) Arrays.stream(words).filter(s::startsWith).count();
    }
    public void stringFunctionTest(){
        String str1 = "I am jrr!";
        String str2 = "I am jr jr jr jr!";
        System.out.println(str2.substring(0,3));
    }
    public static void main(String[] args){
        Solution s = new Solution();
        s.stringFunctionTest();
    }
}

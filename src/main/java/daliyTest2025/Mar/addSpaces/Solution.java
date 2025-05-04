package daliyTest2025.Mar.addSpaces;

public class Solution {
    public String addSpaces(String s,  int[] space){
        int count = space.length;
        char[] str = s.toCharArray();
        int len = s.length() + count;
        int i = 0, j = len -1;
        char[] tchars = new char[len];
        boolean[] st = new boolean[len];
        for(int k = 0;k<count;k++){
            st[k+space[k]] = true;
        }
        int l = 0, r = 0;
        while(i<=j){
            if(st[i]){
                tchars[i] = ' ';
                i += 1;
                l += 1;
            }
            if(st[j]){
                tchars[j] = ' ';
                j -= 1;
                r += 1;
            }
            tchars[i] = str[i-l];
            tchars[j] = str[j - count + r];
            i++;
            j--;
        }
        return new String(tchars);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addSpaces("LeetcodeHelpsMeLearn",new int[] {8,13,15}));
    }
}

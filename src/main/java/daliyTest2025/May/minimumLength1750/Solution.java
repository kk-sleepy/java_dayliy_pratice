package daliyTest2025.May.minimumLength1750;

class Solution {
    public int minimumLength(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int l = 0, r = n -1;
        while(l<r && str[l] == str[r]){
            char cur = str[l];
            while(l<=r &&str[l] == cur){
                l+=1;
            }
            while(l<=r && str[r] == cur){
                r -= 1;
            }
        }
        return r - l + 1;
    }
}

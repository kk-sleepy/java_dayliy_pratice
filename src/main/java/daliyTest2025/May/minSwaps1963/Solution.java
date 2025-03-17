package daliyTest2025.May.minSwaps1963;

public class Solution {
    public int minSwaps(String s){
        char[] str = s.toCharArray();
        int n = str.length;
        int j = n-1;
        int ans = 0,c=0;
        for(int i=0;i<n;i++){
            if(str[i]=='['){
                c += 1;
            }else if(c>0){
                c -= 1;
            }else{
                while(str[j]==']'){
                    j--;
                }
                str[j] = ']';
                ans += 1;
                c += 1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.minSwaps("]]][[["));
    }
}

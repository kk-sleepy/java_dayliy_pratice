package daliyTest2025.May.shortestBeautifulSubstring2904;

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int l = 0, count = 0;
        String ans = "";
        for(int i = 0;i<n;i++){
            count += s.charAt(i) - '0';
            while (count == k){
                count -= s.charAt(l) - '0';
                String x = s.substring(l,i+1);
                if(ans.isEmpty() || x.length() < ans.length()){
                    ans = x;
                }
                if(x.length() == ans.length() && x.compareTo(ans) < 0){
                    ans = x;
                }
                l += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.shortestBeautifulSubstring("100011001",3));
//        System.out.println("11001".compareTo("100011"));
    }
}
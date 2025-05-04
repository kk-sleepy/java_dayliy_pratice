package daliyTest2025.Mar.maxArea;

public class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int h;
            if(height[l]>=height[r]){
                h = height[r];
                ans = Math.max(ans, h * (r - l));
                r -= 1;
            }else{
                h = height[l];
                ans = Math.max(ans, h * (r - l));
                l += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}

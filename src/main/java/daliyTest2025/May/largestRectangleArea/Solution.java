package daliyTest2025.May.largestRectangleArea;

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] left = new int[n], right = new int[n];
        for(int i = 0;i<n;i++){
            int height = heights[i];
            while(!st.isEmpty() && heights[st.peek()] >= height){
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i = n-1;i>=0;i--){
            int height = heights[i];
            while(!st.isEmpty() && heights[st.peek()] >= height){
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        for(int i = 0;i<n;i++){
            ans = Math.max(ans,heights[i] * (right[i] - left[i] - 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s  = new Solution();
        System.out.println(s.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}

package daliyTest2025.June.nextGreaterElements503;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> st = new LinkedList<>();
        for(int i = 0;i<2*n;i++){
            if(i<n){
                ans[i] = -1;
            }
            int x = nums[i%n];
            while(!st.isEmpty() && nums[st.peek()] < x){
                int j = st.poll();
                ans[j] = x;
            }
            st.addFirst(i%n);
        }
        return ans;
    }
}

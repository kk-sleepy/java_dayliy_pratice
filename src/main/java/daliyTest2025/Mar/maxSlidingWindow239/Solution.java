package daliyTest2025.Mar.maxSlidingWindow239;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] maxSlidingWindow(int[] nums,int k){
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!dq.isEmpty()&&nums[i]>=nums[dq.getLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
            // 2. 出
            if (i - dq.getFirst() >= k) { // 队首已经离开窗口了
                dq.removeFirst();
            }
            // 3. 记录答案
            if (i >= k - 1) {
                // 由于队首到队尾单调递减，所以窗口最大值就是队首
                ans[i - k + 1] = nums[dq.getFirst()];
            }
        }
        return ans;
     }
     public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] ans = s.maxSlidingWindow(nums,3);
        for(int x : ans){
            System.out.print(x + " ");
        }
     }
}

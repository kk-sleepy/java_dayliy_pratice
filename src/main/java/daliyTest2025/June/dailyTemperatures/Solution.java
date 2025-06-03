package daliyTest2025.June.dailyTemperatures;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0;i<n;i++){
            while(!deque.isEmpty() && temperatures[i] > temperatures[deque.peek()]){
                int idx = deque.pop();
                ans[idx] = i - idx;
            }
            deque.addFirst(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ans = s.dailyTemperatures(new int[]{30,60,90});
        for(int x : ans){
            System.out.print(x + " ");
        }
    }
}

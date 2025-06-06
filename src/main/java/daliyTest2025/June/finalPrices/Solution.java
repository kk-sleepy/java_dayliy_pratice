package daliyTest2025.June.finalPrices;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> st = new LinkedList<>();
        int n = prices.length;
        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && prices[st.peek()] >= prices[i]){
                int x = st.poll();
                prices[x] -= prices[i];
            }
            st.addFirst(i);
        }
        return prices;
    }
}

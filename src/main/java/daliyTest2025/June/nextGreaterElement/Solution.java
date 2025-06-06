package daliyTest2025.June.nextGreaterElement;

import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        Map<Integer,Integer> find = new HashMap<>();
        Deque<Integer> st = new LinkedList<>();
        int[] idx = new int[m];
        for(int i = 0;i<m;i++){
            find.put(nums2[i],i);
            idx[i] = -1;
            while(!st.isEmpty() && nums2[i] > nums2[st.peek()]){
                int x = st.poll();
                idx[x] = nums2[i];
            }
            st.addFirst(i);
        }
        for(int i = 0;i<n;i++){
            int x = nums1[i];
            nums1[i] = idx[find.get(x)];
        }
        return nums1;
    }
}
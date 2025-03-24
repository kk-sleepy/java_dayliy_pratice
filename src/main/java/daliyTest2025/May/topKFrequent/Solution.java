package daliyTest2025.May.topKFrequent;

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> cnt = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] m,int[] n){
                return m[1] - n[1];
            }
        }
        );
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            cnt.merge(nums[i], 1, Integer::sum);
        }
        for(Map.Entry<Integer, Integer> entry : cnt.entrySet()){
            int data = entry.getKey(), count = entry.getValue();
            if(queue.size()<k){
                queue.offer(new int[] {data,count});
            }else{
                if(queue.peek()[1]<count){
                    queue.poll();
                    queue.offer(new int[] {data,count});
                }
            }
        }
        for(int i=0;i<k;i++){
            ans[i] = queue.poll()[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ans = s.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        for (int x : ans) {
            System.out.println(x + " ");
        }
    }
}

package daliyTest2025.Mar.permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] idx = new boolean[nums.length];
        List<Integer> lst = Arrays.asList(new Integer[nums.length]);;
        find(ans,lst,nums,idx,0);
        return ans;
    }
    private void find(List<List<Integer>> ans, List<Integer> lst, int[] nums, boolean[] idx, int level){
        if(level==nums.length){
            ans.add(new ArrayList<>(lst));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(idx[i])
                continue;
            lst.set(level,nums[i]);
            idx[i] = true;
            find(ans,lst,nums,idx,level + 1);
            idx[i] = false;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> ans = s.permute(new int[] {1,2,3});
        ans.forEach((data)->{
            System.out.println(data);
        });
    }
}

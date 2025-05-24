package daliyTest2025.May.countPairs2824;

import java.util.*;
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int ans = 0;
        nums.sort((a,b)->a-b);
        int l = 0, r = nums.size() - 1;
        while(l<r){
            int x = nums.get(l) + nums.get(r);
            if(x>=target){
                r -= 1;
            }else{
                ans += r - l;
                l += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}

package daliyTest2025.May.threeSum15;

import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0;i<n-2;i++){
            if(i !=0 && nums[i] == nums[i-1])
                continue;
            int x = nums[i];
            if(x+nums[i+1]+nums[i+2]>0)
                break;
            if(x+nums[n-2]+nums[n-1]<0)
                continue;
            int l = i + 1, r = n - 1;
            while(l<r){
                int s = nums[l] + nums[r] + x;
                if(s>0){
                    r -=1;
                }else if(s<0){
                    l += 1;
                }else {
                    ans.add(List.of(x,nums[l],nums[r]));
                    l += 1;
                    while(l<r && nums[l] == nums[l-1])
                        l += 1;
                    r -= 1;
                    while(l<r && nums[r] == nums[r+1])
                        r -= 1;
                }
            }
        }
        return ans;
    }
}

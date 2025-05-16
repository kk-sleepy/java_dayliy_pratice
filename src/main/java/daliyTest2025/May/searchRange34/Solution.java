package daliyTest2025.May.searchRange34;

public class Solution {
    public int[] searchRange(int[] nums, int target){
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        if(nums.length<1)
            return ans;
        int pos = check(nums,target);
        if(pos == -1){
            return ans;
        }
        int l = pos, r = pos;
        while(l>=0 && nums[l]==nums[pos]){
            l -= 1;
        }
        while(r<nums.length && nums[r]==nums[pos]){
            r += 1;
        }
        ans[0] = l +1;
        ans[1] = r - 1;
        return ans;
    }
    private int check(int[] nums,int target){
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            int val = nums[mid];
            if(target < val){
                r = mid;
            }else if(target == val){
                l = mid;
                break;
            }else {
                l = mid + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,2,3,5,6};
        int[] ans = s.searchRange(nums,4);
        System.out.println(ans[0] +" "+ ans[1]);
    }
}

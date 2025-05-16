package daliyTest2025.May.findMin;

public class Solution {
    public int findMin(int[] nums){
        int n = nums.length;
        int l = 0, r = n - 1;
        if(nums[l] < nums[r])
            return nums[l];
        while(l<r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < nums[l] || nums[mid] < nums[r]){
                r = mid;
                continue;
            }
            if(nums[mid] > nums[r] || nums[mid] > nums[l]){
                l = mid + 1;
            }
        }
        return nums[l];
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMin(new int[]{4,5,6,7,0,1,2}));
    }
}

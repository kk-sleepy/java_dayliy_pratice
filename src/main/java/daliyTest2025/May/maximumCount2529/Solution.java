package daliyTest2025.May.maximumCount2529;

class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int sum1 = 0,sum2 = 0;
        int x = search(nums,1);
        sum2 = n - x;
        sum1 = search(nums,0);
        return Math.max(sum1,sum2);
    }
    int search(int[] nums,int target){
        int l = 0 , r = nums.length;
        while(l<r){
            int mid = l + (r-l)/2;
            if(nums[mid]<target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0,0,0};
        Solution s = new Solution();
        System.out.println(s.maximumCount(nums));
    }
}

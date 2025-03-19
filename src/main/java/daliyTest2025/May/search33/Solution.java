package daliyTest2025.May.search33;

public class Solution {
    private int ans;
    private boolean state;
    public int search(int[] nums,int target){
        this.ans = -1;
        this.state = false;
        check(nums,0,nums.length-1,target);
        return this.ans;
    }
    private void check(int[] nums,int l, int r,int target){
        int mid = (l+r)>>1;
        if(nums[mid]==target){
            this.ans = mid;
            return;
        }
        if(l>=r)
            return;
        if(!this.state){
            if(nums[mid]>nums[mid+1]) {
                this.state = true;
            }
            check(nums,l,Math.max(0,mid-1),target);
            check(nums,mid+1,r,target);
        }else{
            if(nums[mid]>target){
                check(nums,l,mid,target);
            }else
                check(nums,mid+1,r,target);
        }
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {4,5,6,7,8,1,2,3};
        System.out.println(s.search(nums,8));
    }
}

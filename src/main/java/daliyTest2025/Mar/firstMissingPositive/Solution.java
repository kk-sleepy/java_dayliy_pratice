package daliyTest2025.Mar.firstMissingPositive;


public class Solution {
    public int firstMissingPositive(int[] nums){
        int n = nums.length;
        for(int i=0;i<n;i++){
            while(nums[i]>0&&nums[i]<=n&&nums[nums[i]-1]!=nums[i]){
               swap(nums,nums[i]-1,i);
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        return n+1;
    }
    private void swap(int[] nums,int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.firstMissingPositive(new int[] {3,4,-1,1}));
    }
}

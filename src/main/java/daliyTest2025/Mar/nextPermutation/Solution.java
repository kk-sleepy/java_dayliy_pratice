package daliyTest2025.Mar.nextPermutation;

public class Solution {
    public int[] nextPermutation(int[] nums){
        int n = nums.length;
        int i = n - 2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i -= 1;
        }
        if(i>=0){
            int j = n - 1;
            while(nums[j]<=nums[i]){
                j -= 1;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1,n-1);
        return nums;
    }
    public void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public void reverse(int[] nums,int x, int y){
        while(x<y){
            swap(nums,x,y);
            x += 1;
            y -= 1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for(int x : s.nextPermutation(new int[] {1,2,3})){
            System.out.println(x + " ");
        }
    }
}

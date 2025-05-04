package daliyTest2025.Mar.findMedianSortedArrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        if(nums1.length>nums2.length){
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }
        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m+n+1)>>1;
        int l = 0, r = m;
        while(l < r){
            int mid = l + (r - l + 1) / 2;
            int j = totalLeft - mid;
            if(nums1[mid-1]>nums2[j]){
                r = mid - 1;
            }else{
                l = mid;
            }
        }
        int i = l, j = totalLeft - i;
        int nums1l = i==0 ? Integer.MIN_VALUE : nums1[i-1];
        int nums1r = i==m ? Integer.MAX_VALUE : nums1[i];
        int nums2l = j==0 ? Integer.MIN_VALUE : nums2[j-1];
        int nums2r = j==n ? Integer.MAX_VALUE : nums2[j];
        if((m + n)%2==1){
            return Math.max(nums1l,nums2l);
        }else{
            return (double) ( Math.max(nums1l,nums2l) + Math.min(nums1r,nums2r) ) / 2;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {1,2,3,4,5}, nums2 = {6,7,8,9,10,11,12,13,14,15,16,17};
        System.out.println(s.findMedianSortedArrays(nums1,nums2));
    }
}

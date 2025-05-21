package daliyTest2025.May.minZeroArray3356;

class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int l = 0, r = queries.length;
        if(!check(nums,queries,r))
            return -1;
        while(l < r){
            int mid = (l + r) >>> 1;
            if(check(nums,queries,mid)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    private boolean check(int[] nums, int[][] queries,int mid){
        int n = nums.length;
        int[] cnt = new int[n+ 1];
        for(int i = 0;i<mid;i++){
            int[] data = queries[i];
            cnt[data[0]] += data[2];
            cnt[data[1]+1] -= data[2];
        }
        for(int i = 0;i<n;i++){
            int x = nums[i] - cnt[i];
            if(x > 0)
                return false;
            cnt[i+1] += cnt[i];
        }
        return true;
    }
}
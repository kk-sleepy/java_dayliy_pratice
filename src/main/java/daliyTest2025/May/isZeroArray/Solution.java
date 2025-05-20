package daliyTest2025.May.isZeroArray;

class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] res = new int[n+1];
        for(int[] query : queries){
            res[query[0]] += 1;
            res[query[1]+1] -= 1;
        }
        for(int i = 0;i < n;i++){
            int x = nums[i] - res[i];
            if(x>0)
                return false;
            res[i+1] += res[i];
        }
        return true;
    }

    public static void main(String[] args) {

    }
}

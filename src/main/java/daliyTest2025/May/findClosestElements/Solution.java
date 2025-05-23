package daliyTest2025.May.findClosestElements;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>(k);
        int l = 0 , r = arr.length - 1;
        while(r - l + 1 >k){
            if(Math.abs(arr[r]-x)>Math.abs(arr[l]-x)){
                r -= 1;
            }else{
                l += 1;
            }
        }
        for(int i = l;i<l+k;i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}

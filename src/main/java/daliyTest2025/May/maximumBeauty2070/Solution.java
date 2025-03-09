package daliyTest2025.May.maximumBeauty2070;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries){
        int n = queries.length;
        int l = items.length;
        int[] answer = new int[n];
        Arrays.sort(items,(a,b)-> Integer.compare(a[0], b[0]));
        for(int i=1;i<l;i++){
            items[i][1] = Math.max(items[i-1][1],items[i][1]);
        }
        for(int i=0;i<n;i++){
            answer[i] = query(queries[i],items);
        }
        return answer;
    }
    private int query(int x, int[][] s){
        int n = s.length;
        int l = 0, r=n, mid;
        mid = 0;
        while(l<r){
            mid = (l + r) >> 1;
            if(s[mid][0]>x){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        if(l==0)
            return 0;
        else
            return s[l-1][1];
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[][] items = {{1,2},{3,2},{2,4},{5,6},{3,5}};
        int[] queries = {1,2,3,4,5,6};
        int [] data = s.maximumBeauty(items,queries);
        for(int x:data)
            System.out.println(x);
    }
}

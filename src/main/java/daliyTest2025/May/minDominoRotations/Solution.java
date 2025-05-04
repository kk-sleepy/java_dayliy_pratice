package daliyTest2025.May.minDominoRotations;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms){
        int t = minTrans(tops[0],tops,bottoms);
        int b = minTrans(bottoms[0],tops,bottoms);
        if(t==-1 && b == -1)
            return -1;
        else if(t !=-1 && b != -1)
            return Math.min(t,b);
        else if(t != -1)
            return t;
        return b;
    }
    private int minTrans(int target,int[] tops,int[] bottoms){
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i=0;i<tops.length;i++){
            int t = tops[i];
            int b = bottoms[i];
            if(target != t && target != b)
                return -1;
            if(t == target && b == target)
                continue;
            if(t == target){
                cnt2 += 1;
            }
            if(b == target)
                cnt1 += 1;
        }
        return Math.min(cnt1,cnt2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] tops = new int[]{2, 1, 2, 4, 2, 2};
        int[] bottoms = new int[]{5, 2, 6, 2, 3, 2};
        System.out.println(s.minDominoRotations(tops, bottoms));
    }
}

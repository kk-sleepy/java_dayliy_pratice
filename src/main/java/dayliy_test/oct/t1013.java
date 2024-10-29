package dayliy_test.oct;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution1 {
    public int twoEggDrop(int n) {
        int f[] = new int[n+1];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                f[i] = Math.min(f[i], Math.max(j-1, f[i-j])+1);
            }
        }
        return f[n];
    }

}
public class t1013 {
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        System.out.println(sol.twoEggDrop(100));
    }
}

package daliyTest2025.May.nQueen51;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private List<List<String>> data;
    private int n;
    public List<List<String>> solveNQueens(int n){
        this.data = new ArrayList<>();
        this.n = n;
        int[] queen = new int[n];
        Set<Integer> ans = new HashSet<>();
        Set<Integer> cnt1 = new HashSet<>();
        Set<Integer> cnt2 = new HashSet<>();
        f(0,ans,cnt1,cnt2,queen);
        return this.data;
    }
    private void f(int row, Set<Integer> ans, Set<Integer> cnt1, Set<Integer> cnt2,int[] queen){
        if(row==this.n){
            this.data.add(buildBoard(queen));
            return;
        }
        for(int i=0;i<this.n;i++){
            if(ans.contains(i))
                continue;
            if(cnt1.contains(i+row))
                continue;
            if(cnt2.contains(row-i))
                continue;
            ans.add(i);
            cnt1.add(i+row);
            cnt2.add(row - i);
            queen[row] = i;
            f(row+1,ans,cnt1,cnt2,queen);
            queen[row] = 0;
            ans.remove(i);
            cnt1.remove(i+row);
            cnt2.remove(row-i);
        }
        return;
    }
    private List<String> buildBoard(int[] ans){
        List<String> lstr = new ArrayList<>();
        for(int y:ans){
            String t = "";
            for(int i=0;i<this.n;i++){
                if(i==y){
                    t = t + "Q";
                }else{
                    t = t + ".";
                }
            }
            lstr.add(t);
        }
        return lstr;
    }
}

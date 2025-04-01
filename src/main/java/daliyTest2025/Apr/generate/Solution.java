package daliyTest2025.Apr.generate;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> list = new ArrayList<>();
            if(i==0){
                list.add(1);
            }else{
                List<Integer> temp = new ArrayList<>(ans.getLast());
                temp.addFirst(0);
                temp.addLast(0);
                for(int j = 1;j<temp.size();j++){
                    list.add(temp.get(j-1) + temp.get(j));
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> ans = s.generate(4);
        for(List<Integer> list: ans){
            list.forEach((x)->{
                System.out.print(x+" ");
            });
            System.out.println();
        }
    }
}

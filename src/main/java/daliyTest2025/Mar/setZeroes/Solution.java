package daliyTest2025.Mar.setZeroes;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public void setZeroes(int[][] matrix){
        int n = matrix.length, m = matrix[0].length;
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row.contains(i)||col.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }

    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[][] m = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        s.setZeroes(m);
    }
}

package daliyTest2025.May.searchMatrix74;

public class Solution {
    private int target;
    public boolean searchMatrix(int[][] matrix, int target) {
        this.target = target;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return check(matrix, 0, matrix[0].length-1);
    }
    private boolean check(int[][] matrix, int x, int y) {
        if(y<0 || x>=matrix.length)
            return false;
        if(matrix[x][y] == target)
            return true;
        if(matrix[x][y] > target){
            return check(matrix,x,y-1);
        }
        return check(matrix,x+1,y);
    }
    public static void main(String[] args) {
        daliyTest2025.May.searchMatrix.Solution s = new daliyTest2025.May.searchMatrix.Solution();
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(s.searchMatrix(matrix,5));
    }
}

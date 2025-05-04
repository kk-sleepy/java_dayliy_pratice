package daliyTest2025.May.searchMatrix;

public class Solution {
    private int target;
    public boolean searchMatrix(int[][] matrix, int target) {
        this.target = target;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return check(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private boolean check(int[][] matrix, int x1, int y1, int x2, int y2) {
        if (x1 > x2 || y1 > y2) {
            return false;
        }
        int xmid = x1 + (x2 - x1) / 2;
        int ymid = y1 + (y2 - y1) / 2;

        if (matrix[xmid][ymid] == target) {
            return true;
        } else if (matrix[xmid][ymid] > target) {
            return check(matrix, x1, y1, xmid - 1, y2) || check(matrix, xmid, y1, x2, ymid - 1);
        } else {
            return check(matrix, xmid + 1, y1, x2, y2) || check(matrix, x1, ymid + 1, xmid, y2);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(s.searchMatrix(matrix,5));
    }
}

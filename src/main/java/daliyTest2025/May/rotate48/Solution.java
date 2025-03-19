package daliyTest2025.May.rotate48;

public class Solution {
    public void rotate(int[][] matrix){
        //先对矩阵进行转置
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //再对矩阵按照中心对称的列进行转换
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[][] data = {{1,2,3},{4,5,6},{7,8,9}};
        s.rotate(data);
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[0].length;j++){
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}

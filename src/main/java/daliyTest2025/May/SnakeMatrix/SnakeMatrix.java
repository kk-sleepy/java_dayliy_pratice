package daliyTest2025.May.SnakeMatrix;

import java.util.ArrayList;
import java.util.List;

public class SnakeMatrix {
    public static List<Integer> snakeOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int m = matrix.length;    // rows
        int n = matrix[0].length; // columns
        boolean goDown = true;

        for (int col = 0; col < n; col++) {
            if (goDown) {
                // Going down
                for (int row = 0; row < m; row++) {
                    result.add(matrix[row][col]);
                }
            } else {
                // Going up
                for (int row = m - 1; row >= 0; row--) {
                    result.add(matrix[row][col]);
                }
            }
            goDown = !goDown; // Switch direction for next column
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> result = snakeOrder(matrix);
        System.out.println(String.join(" ", result.stream()
                .map(String::valueOf)
                .toArray(String[]::new)));
    }
}

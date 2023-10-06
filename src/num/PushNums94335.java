package num;

import java.util.Arrays;

/**
 * 94335. 숫자 밀기_빈칸채우기
 * 이차원 배열의 숫자를 밀기
 */
public class PushNums94335 {
    public static void main(String[] args) {
        PushNums94335 q = new PushNums94335();
        
        int n = 3;
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        String[] direction = {"left", "down", "right"};

        System.out.println(Arrays.deepToString(q.solution(n, matrix, direction))); // 2차원 배열 출력하는 메서드
        
    }

    private int[][] solution(int n, int[][] matrix, String[] direction) {

        for (String dir : direction) {
            switch (dir) { // 향상된 Switch문
                case "left" -> func_a(n, matrix);
                case "right" -> func_b(n, matrix);
                case "up" -> func_c(n, matrix);
                case "down" -> func_d(n, matrix);
            }
        }

//        for (String dir : direction) {
//            if (dir.equals("left")) func_a(n, matrix);
//            else if (dir.equals("right")) func_b(n, matrix);
//            else if (dir.equals("up")) func_c(n, matrix);
//            else if (dir.equals("down")) func_d(n, matrix);
//        }

        return matrix;
    }

    private void func_a(int n, int[][] matrix) { // left 이동
        for (int i = 0; i < n; i++) {
            int temp = matrix[i][0]; // 0열 값을 복사
            for (int j = 0; j < n - 1; j++) {
                matrix[i][j] = matrix[i][j+1];
            }
            matrix[i][n-1] = temp; // 복사한 값을 n-1열에 붙여넣기
        }
    }

    private void func_b(int n, int[][] matrix) { // right 이동
        for (int i = 0; i < n; i++) {
            int temp = matrix[i][n-1]; // n-1열 값을 복사
            for (int j = n - 1; j > 0; j--) {
                matrix[i][j] = matrix[i][j-1];
            }
            matrix[i][0] = temp; // 복사한 값을 0열에 붙여넣기
        }
    }

    private void func_c(int n, int[][] matrix) { // up 이동
        for (int j = 0; j < n; j++) {
            int temp = matrix[0][j]; // 0행 값을 복사
            for (int i = 0; i < n - 1; i++) {
                matrix[i][j] = matrix[i+1][j];
            }
            matrix[n-1][j] = temp; // 복사한 값을 n-1행에 붙여넣기
        }
    }

    private void func_d(int n, int[][] matrix) { // down 이동
        for (int j = 0; j < n; j++) {
            int temp = matrix[n-1][j]; // n-1행 값을 복사
            for (int i = n-1; i > 0; i--) {
                matrix[i][j] = matrix[i-1][j];
            }
            matrix[0][j] = temp; // 복사한 값을 0행에 붙여넣기
        }
    }

}

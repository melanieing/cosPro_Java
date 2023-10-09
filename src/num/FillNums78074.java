package num;

import java.util.Arrays;
/**
 * 78074. 숫자 채우기_빈칸채우기
 * 규칙대로 2차원 배열의 각 칸에 숫자를 채우고,
 * 같은 칸에 채운 숫자끼리 합하여 2차원 배열 형태로 반환
 */
public class FillNums78074 {

    public int[][] answer = {};

    public static void main(String[] args) {
        FillNums78074 q = new FillNums78074();
        int n = 3;

        System.out.println(Arrays.deepToString(q.solution(n)));
    }

    private int[][] solution(int n) {
        answer = new int[n][n];

        funcA(n); // 좌측 아래 정렬
        funcB(n); // 좌측 위 정렬
        funcC(n); // 우측 아래 정렬
        funcD(n); // 우측 위 정렬

        return answer;
    }

    public void funcA(int n) {
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++, num++) {
                answer[i][j] += num;
            }
        }
    }

    public void funcB(int n) {
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n-i); j++, num++) {
                answer[i][j] += num;
            }
        }
    }

    public void funcC(int n) {
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i+j >= n-1) {
                    answer[i][j] += num;
                    num++;
                }
            }
        }
    }

    public void funcD(int n) {
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i <= j) {
                    answer[i][j] += num;
                    num++;
                }
            }
        }
    }
}

package search;

import java.awt.*;
import java.util.*;
/**
 * 75066. 쓰레기 매립지_디버깅
 * 쓰레기가 모두 썩어서 없어지는데 며칠이 걸리는지?
 */
public class LandFill75066 {
    public static void main(String[] args) {
        LandFill75066 q = new LandFill75066();
        int n = 3;          // 땅의 가로/세로 길이
        int x = 1, y = 1;   // 맨 처음 썩기 시작한 쓰레기의 좌표

        System.out.println(q.solution(n, x, y));
    }

    private int solution(int n, int x, int y) {
        int[][] matrix = new int[101][101];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int maxDist = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j ++) {
                matrix[i][j] = -1; // 일단 초기화
            }
        }

        Queue<Point> q = new LinkedList<>();
        matrix[x][y] = 0; // 시작점
        q.offer(new Point(x, y));

        while (!q.isEmpty()) {
            int curX = (int) q.peek().getX();
            int curY = (int) q.peek().getY();
            maxDist = Math.max(maxDist, matrix[curX][curY]); // 모두 없어질 때까지 -> max값 구하기
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= n|| nextY >= n) continue;
                if (matrix[nextX][nextY] == -1) {
                    matrix[nextX][nextY] = matrix[curX][curY] + 1;
                    q.offer(new Point(nextX, nextY));
                }
            }
        }
        return maxDist + 3; // 쓰레기는 썩기 시작한 이후로 3일이 지나면 완전히 사라짐
    }
}

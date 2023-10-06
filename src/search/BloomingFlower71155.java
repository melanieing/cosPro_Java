package search;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 71155. 꽃피우기_함수 작성
 * 모든 꽃이 피는데 며칠이 걸리는지?
 */
public class BloomingFlower71155 {
    public static void main(String[] args) {
        BloomingFlower71155 q = new BloomingFlower71155();
        int[][] garden = {{0,0,0}, {0,1,0}, {0,0,0}};

        System.out.println(q.solution(garden));
    }

    private int solution(int[][] garden) {
        int day = 0;
        Queue<Point> flowers = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden[i].length; j++) {
                if (garden[i][j] == 1) { // 꽃이 피어있는 곳을 기록
                    flowers.add(new Point(i, j));
                }
            }
        }

        while (!flowers.isEmpty()) {
            Point cp = flowers.poll();
            int cx = (int)cp.getX();
            int cy = (int)cp.getY();
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || ny < 0 || nx >= garden.length || ny >= garden.length) {
                    continue;
                }
                if (garden[nx][ny] == 0) { // 꽃이 피지 않은 곳이라면
                    day = Math.max(day, garden[cx][cy]); // 이렇게 해주면 -1할 필요 없음
                    garden[nx][ny] = garden[cx][cy] + 1; // 꽃이 피었다고 표시
                    flowers.add(new Point(nx, ny)); // 다시 기록
                }
            }
        }

        return day;
    }
}

package search;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 82727. 뮤직 페스티벌
 * 뮤직 페스티벌에 참가한 팬들이 좋아하는 서로 다른 가수는 총 몇 명?
 */
public class MusicFestival82727 {
    public static void main(String[] args) {
        MusicFestival82727 q = new MusicFestival82727();
        int[][] seats = {{1,1,0},{1,0,0},{0,0,1}};

        System.out.println(q.solution(seats));
    }

    private int solution(int[][] seats) {
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = seats.length;
        int[][] visited = new int[50][50];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && seats[i][j] == 1) {
                    answer++; // 새로운 가수라는 의미

                    Queue<int[]> q = new LinkedList<>();
                    visited[i][j] = 1;
                    q.offer(new int[]{i, j});

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = cur[0] + dx[k];
                            int ny = cur[1] + dy[k];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                                continue;
                            }
                            if (visited[nx][ny] == 1 || seats[nx][ny] == 0) { // 이미 방문했거나 빈 자리는 넘어가기
                                continue;
                            }
                            visited[nx][ny] = 1;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return answer;
    }
}

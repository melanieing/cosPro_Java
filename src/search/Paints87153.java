package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 82727. 물감_빈칸채우기
 * 사용하게 될 물감별로 각각 몇 칸씩 칠하게 되는지 1차원 정수 배열에 담아 오름차순 정렬
 */
public class Paints87153 {

    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, 1, 0, -1};
    public int n;
    public int[][] visited = new int[50][50];
    public int[][] coloring;

    public static void main(String[] args) {
        Paints87153 q = new Paints87153();
        int[][] coloring = {{1,1,0,0}, {1,1,0,1}, {0,0,1,1}, {1,0,0,0}};

        System.out.println(Arrays.toString(q.solution(coloring)));
    }

    public int[] solution(int[][] coloring) {
        List<Integer> answerList = new ArrayList<>();
        n = coloring.length;
        this.coloring = coloring;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && coloring[i][j] == 1) {
                    answerList.add(dfs(i, j));
                }
            }
        }

        Collections.sort(answerList);

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public int dfs(int x, int y) {
        int count = 1;
        visited[x][y] = 1;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) { // 범위 밖이면 넘어가기
                continue;
            }
            if (visited[nx][ny] == 1 || coloring[nx][ny] == 0) { // 방문한 적 있거나 색칠 안 할 부분이라면
                continue;
            }
            count += dfs(nx, ny);
        }

        return count;
    }
}

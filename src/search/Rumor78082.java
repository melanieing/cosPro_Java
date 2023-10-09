package search;

import java.util.*;

/**
 * 78082. 소문_함수 작성
 * 1번 학생이 소문을 만들었을 때 k번 학생이 소문을 전달받기까지 거쳐야 하는 학생 수의 최솟값
 * k번 학생이 소문을 전달받을 수 없다면 -1
 */
public class Rumor78082 {
    public static void main(String[] args) {
        Rumor78082 q = new Rumor78082();
        int n = 5; // 재학생 수
        int k = 3; // 학생 번호
        int[][] acquaintance = {{1,2}, {3,2}, {4,5}};
//        int[][] acquaintance = {{2,3},{4,3},{3,5}};
//        int[][] acquaintance = {{2,1},{2,3},{4,1},{5,4},{3,4},{3,5}};

        System.out.println(q.solution(n, k, acquaintance));
    }

    private int solution(int n, int k, int[][] acquaintance) {

        int[][] adj = new int[101][101];    // 인접행렬
        int[] visited = new int[101];       // 방문배열
        int[] distance = new int[101];      // 거리배열

        for (int[] ac : acquaintance) { // 인접행렬 채우기
            adj[ac[0]][ac[1]] = 1;
            adj[ac[1]][ac[0]] = 1;
        }

        Arrays.fill(distance, -1); // 거리는 -1로 초기화

        Queue<Integer> queue = new LinkedList<>();

        // 출발점 1 기록
        queue.offer(1);
        visited[1] = 1;
        distance[1] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next = 1; next <= n; next++) {
                if (adj[cur][next] == 1 && visited[next] == 0) { // 인접하고 방문한적 없으면
                    queue.offer(next);
                    visited[next] = 1;
                    distance[next] = distance[cur] + 1; // 거리 기록
                }
            }
        }

        return distance[k]; // k까지의 최단거리

    }
}

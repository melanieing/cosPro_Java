package dataStructure;

import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 87159. 응급실_디버깅
 * 환자 번호가 k번인 환자는 몇 번째로 진료받게 될지?
 */
public class Emergency87159 {
    public static void main(String[] args) {
        Emergency87159 q = new Emergency87159();
        int[][] patients = {{1,10,1}, {1,20,2}, {0}, {0}, {1,30,3}, {0}};
        int k = 1;

        System.out.println(q.solution(patients, k));
    }

    private int solution(int[][] patients, int k) {
        int answer = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]); // 응급도를 기준으로 우선순위 설정

        for (int i = 0; i < patients.length; i++) {
            if (patients[i][0] == 1) { // 접수라면 큐에 넣기
                pq.offer(new int[]{patients[i][1], patients[i][2]});
            } else if (patients[i][0] == 0) { // 진료라면
                answer++;
                if (Objects.requireNonNull(pq.peek())[1] == k) { // k번 환자일 경우 끝내기
                    break;
                }
                pq.poll();
            }
        }

        return answer;
    }
}

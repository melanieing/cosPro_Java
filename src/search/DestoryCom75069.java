package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 75069. 컴맹의 반란_함수 작성
 * 영희가 폭파시킬 컴퓨터의 개수는? (1번과 연결된 컴퓨터는 모두 폭파해야 함)
 */
public class DestoryCom75069 {
    public static void main(String[] args) {
        DestoryCom75069 q = new DestoryCom75069();
        int n = 5;
        int[][] connect = {{1,2}, {3,2}, {4,5}};

        System.out.println(q.solution(n, connect));
    }

    public int solution(int n, int[][] connect) {
        int answer = 1; // 기본적으로 1번 컴퓨터는 폭파시켜야 하므로 1로 초기화
        
        ArrayList<Integer>[] list = new ArrayList[n+1]; // 연결리스트에 연결정보 표시
        for (int i = 1; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] ints : connect) { // 양방향 모두 표시
            list[ints[0]].add(ints[1]);
            list[ints[1]].add(ints[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n+1]; // 방문여부 표시 배열
        queue.offer(1); // 1번 컴퓨터부터 시작
        visit[1] = true;

        while (!queue.isEmpty()) {
            for (int value : list[queue.poll()]) {
                if (!visit[value]) { // 처음 방문이면 큐에 넣기
                    queue.offer(value);
                    visit[value] = true;
                    answer++;
                }
            }
        }

        return answer;
    }
}

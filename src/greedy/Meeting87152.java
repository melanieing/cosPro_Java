package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 87152. 회의 일정_빈칸채우기
 * 가장 많은 사원이 참여할 수 있는 회의 시작 시각을 모두 찾아 오름차순 정렬
 */
public class Meeting87152 {
    public static void main(String[] args) {
        Meeting87152 q = new Meeting87152();
        int[][] meeting = {{8,9,10},{8,10,15},{13}};

        System.out.println(Arrays.toString(q.solution(meeting)));
    }

    private int[] solution(int[][] meeting) {
        int[] answer;
        int[] time = new int[24];

        for (int i = 0; i < meeting.length; i++) {
            for (int j = 0; j < meeting[i].length; j++) {
                time[meeting[i][j]]++; // 빈도수 카운트
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= 23; i++) {
            if (time[i] > maxTime) {
                maxTime = time[i]; // 빈도 최댓값 기록
            }
        }

        List<Integer> answerList = new ArrayList<>();
        for (int i = 1; i <= 23; i++) {
            if (time[i] == maxTime) {
                answerList.add(i); // 빈도 최댓값에 해당하는 시간 기록
            }
        }

        answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i); // ArrayList -> Array
        }

        return answer;
    }
}

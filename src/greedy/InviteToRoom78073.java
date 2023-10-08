package greedy;
/**
 * 75067. 자취방 초대_빈칸채우기
 * 문제에 주어진 조건을 지키면서 서로 방문 시각이 겹치지 않게 최대 몇 명의 손님을 맞이할 수 있는지?
 */
public class InviteToRoom78073 {
    public static void main(String[] args) {
        InviteToRoom78073 q = new InviteToRoom78073();
        int[][] schedule = {{7,5,10}, {2,10,15}, {5,15,40}, {10,40,70}};

        System.out.println(q.solution(schedule));
    }

    private int solution(int[][] schedule) {
        int answer = 0;
        for (int i = 0; i < schedule.length; i++) { // 친밀도가 5 이상이면 휴식시간 5분 추가
            if (schedule[i][0] > 5) {
                schedule[i][2] += 5;
            }
        }

        for (int i = schedule.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (schedule[j][2] > schedule[j+1][2]) { // 종료시각이 늦을수록 뒤에 배치
                    int[] temp = schedule[j];
                    schedule[j] = schedule[j+1];
                    schedule[j+1] = temp;
                }
            }
        }

        int t = 0;
        for (int i = 0; i < schedule.length; i++) {
            if (t <= schedule[i][1]) { // 앞 방문의 종료 시각보다 다음 방문의 시작 시간이 같거나 크면 방문 가능
                answer++;
                t = schedule[i][2];
            }
        }

        return answer;
    }
}

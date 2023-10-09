package search;
/**
 * 78078. 전구_디버깅
 * 스위치를 누르는 행동을 모두 마친 후 켜져 있는 전구의 개수?
 */
public class Bulb78078 {
    public static void main(String[] args) {
        Bulb78078 q = new Bulb78078();
        int n = 3;
        int[] bulbs = {2, 3, 2};

        System.out.println(q.solution(n, bulbs));
    }

    private int solution(int n, int[] bulbs) {
        int answer = 0;
        int[] light = new int[11];

        // 전구 상태 표시
        for (int bulb : bulbs) {
            light[bulb] = 1 - light[bulb]; // 토글
        }

        // 켜진 전구 개수 구하기
        for (int i = 1; i <= n; i++) {
            if (light[i] == 1) {
                answer++;
            }
        }
        return answer;
    }
}

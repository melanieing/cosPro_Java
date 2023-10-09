package num;

import java.util.Arrays;
/**
 * 82729. 가위바위보_함수 작성
 * 모든 라운드를 마친 후 영희와 철수의 점수를 [영희 점수, 철수 점수] 순서로 담은 배열
 */
public class Gawibawibo82729 {
    public static void main(String[] args) {
        Gawibawibo82729 q = new Gawibawibo82729();
        int[][] gawibawibo = {{2,0,5},{5,0,2}};

        System.out.println(Arrays.toString(q.solution(gawibawibo)));
    }

    public int[] solution(int[][] gawibawibo) {
        int[] answer = new int[2];
        // 2 + 0 = 2 (0이 승리)
        // 2 + 5 = 7 (2이 승리)
        // 0 + 5 = 5 (5가 승리)

        for (int i = 0; i < gawibawibo[0].length; i++) {
            int yh = gawibawibo[0][i]; // 영희가 낸 것
            int cs = gawibawibo[1][i]; // 철수가 낸 것
            if (yh + cs == 2) {
                if (yh < cs) {
                    answer[0]++;
                } else {
                    answer[1]++;
                }
            } else if (yh + cs == 5) {
                if (yh > cs) {
                    answer[0]++;
                } else {
                    answer[1]++;
                }
            } else if (yh + cs == 7) {
                if (yh < cs) {
                    answer[0]++;
                } else {
                    answer[1]++;
                }
            }

        }

        return answer;
    }
}

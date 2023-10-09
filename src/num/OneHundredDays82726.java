package num;

import java.util.Arrays;
/**
 * 82726. 100일_디버깅
 * 그로부터 100일째 되는 날이 몇 월 며칠?
 */
public class OneHundredDays82726 {
    public static void main(String[] args) {
        OneHundredDays82726 q = new OneHundredDays82726();
        int month = 10;
        int date = 3;

        System.out.println(Arrays.toString(q.solution(month, date)));
    }

    private int[] solution(int month, int date) {
        int[] answer = new int[2];
        int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int cnt = 100;
        while (cnt > 1) {
            if (date + 1 <= day[month]) { // 다음날이 말일보다 작거나 같으면
                date++;
            } else { // 다음날이 말일보다 크면
                date = 1;
                month++;
                if (month > 12) {
                    month = 1;
                }
            }
            cnt--;
        }

        answer[0] = month;
        answer[1] = date;

        return answer;
    }
}

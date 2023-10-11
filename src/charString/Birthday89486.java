package charString;

import java.util.Arrays;
/**
 * 89486. 생일_함수 작성
 * 생일이 빠른 순으로 정렬한 배열을 return
 */
public class Birthday89486 {
    public static void main(String[] args) {
        Birthday89486 q = new Birthday89486();
        String[] birthday = {"9/27", "10/13", "5/9", "9/4"};

        System.out.println(Arrays.toString(q.solution(birthday)));
    }

    private String[] solution(String[] birthday) {

        for (int i = 0; i < birthday.length; i++) {
            for (int j = i+1; j < birthday.length; j++) {
                String[] date1 = birthday[i].split("/");
                String[] date2 = birthday[j].split("/");
                int month1 = Integer.parseInt(date1[0]);
                int month2 = Integer.parseInt(date2[0]);
                int day1 = Integer.parseInt(date1[1]);
                int day2 = Integer.parseInt(date2[1]);

                if (month1 > month2) {
                    String tmp = birthday[i];
                    birthday[i] = birthday[j];
                    birthday[j] = tmp;
                } else if (month1 == month2) {
                    if (day1 > day2) {
                        String tmp = birthday[i];
                        birthday[i] = birthday[j];
                        birthday[j] = tmp;
                    }
                }
            }
        }

        return birthday;
    }
}

package charString;
/**
 * 78080. 밸런타인데이_함수 작성
 * 영희가 좋아하는 날짜의 개수?
 */
public class ValentinesDay78080 {
    public static void main(String[] args) {
        ValentinesDay78080 q = new ValentinesDay78080();
        String[] dates = {"2/14", "6/8", "10/13"};

        System.out.println(q.solution(dates));
    }

    private int solution(String[] dates) {
        int answer = 0;

        for (String date : dates) {
            date = date.replace("/", "");
            Character[] newDate = date.chars().mapToObj(c -> (char)c).distinct().toArray(Character[]::new);
            int cnt = 0;
            for (char d : newDate) {
                int tmp = 0;
                while (tmp <= d - '0') {
                    if ((d - '0') == Math.pow(2, tmp++)) { // 2의 거듭제곱에 해당하면 탈출
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt == newDate.length) { // 모든 숫자가 조건을 만족하면 하나 올리기
                answer++;
            }
        }

        return answer;
    }
}

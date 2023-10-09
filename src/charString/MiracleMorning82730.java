package charString;
/**
 * 82730. 미라클모닝_함수 작성
 * 며칠 동안 미라클모닝을 성공했는지?
 */
public class MiracleMorning82730 {
    public static void main(String[] args) {
        MiracleMorning82730 q = new MiracleMorning82730();
        String[] time = {"06:30 am", "07:00 am", "04:50 am"};

        System.out.println(q.solution(time));
    }

    public int solution(String[] time) {
        int answer = 0;

        for (String t : time) {
            if (t.contains("pm")) { // 오후면 넘어가기
                continue;
            }
            t = t.substring(0, 2) + t.substring(3, 5); // 시간만 추출
            int tmp = Integer.parseInt(t); // 숫자로 변환
            if (tmp >= 300 && tmp <= 630) {
                answer++;
            }
        }

        return answer;
    }
}

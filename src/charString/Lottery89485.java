package charString;
/**
 * 89485. 복권_함수 작성
 * 두 문자열이 일치하면 당첨금액의 전부를 받고, 그중 한 글자만 다르다면 당첨금액의 절반을 받는 복권
 * 영희가 받게 될 총금액은?
 */
public class Lottery89485 {
    public static void main(String[] args) {
        Lottery89485 q = new Lottery89485();
        String[][] lottery = {{"apple", "apple"}, {"dog", "dot"}, {"love", "like"}};
        int money = 1000;

        System.out.println(q.solution(lottery, money));
    }

    public int solution(String[][] lottery, int money) {
        int answer = 0;

        for (String[] lotto : lottery) {
            String s1 = lotto[0];
            String s2 = lotto[1];
            if (s1.equals(s2)) { // 두 문자열이 일치할 때,
                answer += money;
            } else { // 두 문자열이 불일치할 때,
                if (s1.length() == s2.length()) { // 두 문자열의 길이는 일치
                    int idx = 0;
                    int cnt = 0; // 다른 문자 개수
                    while (idx < s1.length()) {
                        if (s1.charAt(idx) != s2.charAt(idx)) {
                            cnt++;
                        }
                        idx++;
                    }
                    if (cnt == 1) { // 1개만 다르다면
                        answer += money / 2;
                    }
                }
            }
        }

        return answer;
    }
}

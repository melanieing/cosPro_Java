package regExp;

import java.util.regex.Pattern;

/**
 * 94341. 이메일 주소_함수 작성
 * 이메일의 형식이 올바른지 확인하는 프로그램
 */
public class Email94341 {
    public static void main(String[] args) {
        Email94341 q = new Email94341();
        String[] emails = {"example@example.com", "example@example", "example@.com"};

        System.out.println(q.solution(emails));
    }

    private int solution(String[] emails) {
        int answer = 0;
        String pattern = "^[a-z]+@[a-z]+\\.[a-z]+$";

        for (String email : emails) {
            if (Pattern.matches(pattern, email)) {
                answer++;
            }
        }

        return answer;
    }
}
